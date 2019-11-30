package PetShop.gui.controllers.agendamento;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import PetShop.Main;
import PetShop.gui.controllers.MenuInicialController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaAgendamentoController implements Initializable {
    private String dataAtual;
    private DateTimeFormatter formatter;

    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> choiceAgendamentos;
    @FXML
    private Pane painelAgendamento;

    public TelaAgendamentoController(){
        this.dataAtual = LocalDate.now().toString();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date());
        gc.add(Calendar.HOUR,-1);
        this.dataAtual = sdfData.format(gc.getTime());

    }
    /**
     * Initializes the controller class.
     */
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
        ArrayList<String> lista = Main.petShop.consultarListaHorariosLivres(data);

        ObservableList<String> choicesList = FXCollections.observableArrayList(lista);
        choiceAgendamentos.setItems(choicesList);
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../../views/MenuInicial.fxml"));
            painelAgendamento.getChildren().setAll(menuInicial);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void agendarBtnHandler(ActionEvent actionEvent) {
        if (choiceAgendamentos.getValue()!=null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/agendamento/TelaServico.fxml"));
                Parent root = loader.load();
                TelaServicoController telaServicoController = loader.getController();

                String data = datePicker.getValue().format(formatter);
                String hora = choiceAgendamentos.getValue();
                telaServicoController.transferirInfo(data, hora);

                Main.stageMain.setScene(new Scene(root));
                Main.stageMain.show();
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
