/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gui.ProjetoPoo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.contratos.ServicoAbstrato;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;
import negocio.excecoes.ClienteInexistenteException;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaListarHistoricoServicoController implements Initializable {
    private Alert spam;

    @FXML
    private TableView<ServicoAbstrato> tbView;
    @FXML
    private Pane painelListaServico;
    @FXML
    private TextField inputCpf;
    @FXML
    private DatePicker dateSearch;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbNome;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbCpf;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbTipoServico;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbPet;
    @FXML
    private TableColumn<ServicoAbstrato, String> tbData;
    @FXML
    private TableColumn<?, ?> tbStatus;
    @FXML
    private Button btnVoltar;


    public TelaListarHistoricoServicoController(){
        spam = new Alert(Alert.AlertType.NONE);
        spam.setAlertType(Alert.AlertType.ERROR);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tbNome.setCellValueFactory(cliente -> new SimpleStringProperty(cliente.getValue().getCliente().getNome()));
        tbCpf.setCellValueFactory(cliente -> new SimpleStringProperty(cliente.getValue().getCliente().getCpf()));
        tbTipoServico.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
        tbPet.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getNome()));
        tbData.setCellValueFactory(agendamento -> new SimpleStringProperty(
                (agendamento.getValue().getData() + " - " + agendamento.getValue().getHoraAgendada())));
        tbStatus.setCellValueFactory(
                new PropertyValueFactory<>("Status"));

        preencherHistorico();
    }

    private void preencherHistorico(){
        ArrayList<ServicoAbstrato> servicos = ProjetoPoo.petShop.consultarServicos();

        tbView.getItems().clear();
        for (ServicoAbstrato s: servicos){
            tbView.getItems().add(s);
        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        LocalDate date = dateSearch.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        tbView.getItems().clear();
        if (inputCpf.getLength()>0){
            try{
                Cliente cliente = ProjetoPoo.petShop.consultarCliente(inputCpf.getText());

            } catch (ClienteInexistenteException e) {
                spam.setContentText(e.getMessage());
                spam.show();
                tbView.getItems().clear();
                return;
            }
            if (dateSearch.getValue()!=null){
                String data = date.format(formatter);
                ArrayList<ServicoAbstrato> servicos = ProjetoPoo.petShop.consultarServicosClientePorData(
                        inputCpf.getText(), data);

                for (ServicoAbstrato s: servicos) {
                    tbView.getItems().add(s);
                }
            } else {
                ArrayList<ServicoAbstrato> servicos = ProjetoPoo.petShop.consultarServicosCliente(inputCpf.getText());

                for (ServicoAbstrato s: servicos){
                    tbView.getItems().add(s);
                }
            }
        } else if (dateSearch.getValue()!=null){
            String data = date.format(formatter);
            ArrayList<ServicoAbstrato> servicos = ProjetoPoo.petShop.consultarServicosPorData(data);

            for (ServicoAbstrato s: servicos){
                tbView.getItems().add(s);
            }
        } else {
            preencherHistorico();
        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane listar;
        try {
            listar = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
            painelListaServico.getChildren().setAll(listar);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
