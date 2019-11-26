package gui.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.ProjetoPoo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import negocio.contratos.ServicoAbstrato;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;
import negocio.entidades.ServicoBanho;
import negocio.entidades.ServicoCompleto;


/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaAgendamentoController implements Initializable {
    private String dataAtual;
    private SimpleDateFormat sdfHora;
    private SimpleDateFormat sdfDataComp;
    private GregorianCalendar gc;
    private DateTimeFormatter formatter;

    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> choiceAgendamentos;
    @FXML
    private Button btnAgendar;
    @FXML
    private Button btnVoltar;
    @FXML
    private Pane painelAgendamento;

    /**
     * Initializes the controller class.
     */
    public TelaAgendamentoController(){
        this.dataAtual = LocalDate.now().toString();
        this.sdfHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        this.sdfDataComp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        gc = new GregorianCalendar();
        gc.setTime(new Date());
        gc.add(Calendar.HOUR,-1);
        this.dataAtual = sdfData.format(gc.getTime());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Nao pode selecionar ontem
        LocalDate minDate = LocalDate.now();
        datePicker.setDayCellFactory(d ->
                new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isBefore(minDate));
                    }});

        datePicker.setValue(LocalDate.now());

        preencherListaHoras(this.dataAtual);


    }

    private void preencherListaHoras(String data) {
        ArrayList<ServicoAbstrato> lista = ProjetoPoo.petShop.consultarHorariosAgendados(data);

        ArrayList<String> listaTemp = new ArrayList<String>(Arrays.asList("08:00", "08:30", "09:00", "09:30",
                "10:00","10:30","11:00","11:30","14:00","14:30","15:00","15:30","16:00","16:30"));

        GregorianCalendar horaDoServico = new GregorianCalendar();
        GregorianCalendar horaTemp = new GregorianCalendar();
        ArrayList<String> horasRemovidasTemp = new ArrayList<>();

        if (data.equals(this.dataAtual)) {
            for (String hora : listaTemp) {
                try {
                    horaTemp.setTime(sdfDataComp.parse(this.dataAtual + " " + hora));
                    if (horaTemp.getTime().before(gc.getTime())) {
                        horasRemovidasTemp.add(hora);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                  }
            }
            for (String hora : horasRemovidasTemp){
                listaTemp.remove(hora);
            }
        }

        if (!lista.isEmpty() && !listaTemp.isEmpty()) {
            for (ServicoAbstrato servico : lista) {
                try {
                    horaDoServico.setTime(sdfDataComp.parse(servico.getData() + " " + servico.getHoraAgendada()));
                    if (servico.getDescricao().equals("completo")) {
                        if (listaTemp.contains(servico.getHoraAgendada())){
                            int index = listaTemp.indexOf(servico.getHoraAgendada());
                            listaTemp.remove(index);
                            listaTemp.remove(index);
                        } else {
                            int index = listaTemp.indexOf(servico.getHoraAgendada()) + 1;
                            listaTemp.remove(index);
                        }
                    } else if (!servico.getDescricao().equals("completo") && listaTemp.contains(servico.getHoraAgendada())) {
                        listaTemp.remove(servico.getHoraAgendada());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }


        ObservableList<String> choicesList = FXCollections.observableArrayList(listaTemp);
        choiceAgendamentos.setItems(choicesList);
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/MenuInicial.fxml"));
            painelAgendamento.getChildren().setAll(menuInicial);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void agendarBtnHandler(ActionEvent actionEvent) {
        if (choiceAgendamentos.getValue()!=null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/TelaServico.fxml"));
                Parent root = loader.load();
                TelaServicoController telaServicoController = loader.getController();

                String data = datePicker.getValue().format(formatter);
                String hora = choiceAgendamentos.getValue();
                telaServicoController.transferirInfo(data, hora);

                ProjetoPoo.stageMain.setScene(new Scene(root));
                ProjetoPoo.stageMain.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Selecione um horário!");
            a.show();
        }
    }
    @FXML
    private void inputDataHandler(ActionEvent actionEvent) {
        String data = datePicker.getValue().format(formatter);

        preencherListaHoras(data);
    }

}
