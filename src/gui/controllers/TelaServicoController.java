/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.ProjetoPoo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import negocio.excecoes.ClienteJaCadastradoException;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaServicoController implements Initializable {
    private Alert spam;
    private String hora;
    private String data;
    private Cliente cliente;

    @FXML
    private Pane painelServico;
    @FXML
    private TextField inputBuscarCpf;
    @FXML
    private TableView<PetCliente> tbView;
    @FXML
    private TableColumn<?, ?> nomePet;
    @FXML
    private TableColumn<?, ?> nomeSexo;
    @FXML
    private TableColumn<?, ?> nomeEspecie;
    @FXML
    private ChoiceBox<String> choiceServico;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblAgenda;

    public TelaServicoController(){
        spam = new Alert(Alert.AlertType.NONE);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomePet.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        nomeEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        nomeSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));

        ObservableList<String> choicesList = FXCollections.observableArrayList("Banho", "Tosa", "Completo");

        choiceServico.setValue("");
        choiceServico.setItems(choicesList);

    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputBuscarCpf.getLength()>0){
            tbView.getItems().clear();
            try{
                cliente = ProjetoPoo.petShop.consultarCliente(inputBuscarCpf.getText());
//                ArrayList<ServicoAbstrato> servicosDoCliente = ProjetoPoo.petShop.consultarServicosClienteConcluidos(
//                        cliente.getCpf());
//
//                ArrayList<PetCliente> pets = new ArrayList<>();
//                for (ServicoAbstrato s: servicosDoCliente){
//                    pets.add(s.getPet());
//                }

//                for (PetCliente pet: cliente.getPets()) {
//                    if (!servicosDoCliente.isEmpty()) {
//                        tbView.getItems().add(pet);
//                    } else {
//                        tbView.getItems().add(pet);
//                    }
//                }
                for (PetCliente pet: cliente.getPets()){
                    tbView.getItems().add(pet);
                }
//                if (tbView.getItems().isEmpty()){
//                    spam.setAlertType(Alert.AlertType.ERROR);
//                    spam.setContentText("Nenhum pet disponível do cliente "+cliente.getNome()+" para agendamento!");
//                    spam.show();
//                }

            } catch (ClienteInexistenteException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();

                tbView.getItems().clear();
            }
        } else {
            tbView.getItems().clear();
        }
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
        PetCliente pet = tbView.getSelectionModel().getSelectedItem();
        String descricao = choiceServico.getValue();

        if ((!choiceServico.getValue().equals("")) && (pet!=null)){
            System.out.println("agendar");
            ProjetoPoo.petShop.agendarServico(descricao, hora, data, cliente, pet);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Agendamento marcado! "+"Serviço "+descricao+" no Pet "+ pet.getNome() +
                    " agendado às "+hora+"h do dia "+data);
            spam.show();
            cancelarBtnHandler(event);
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um serviço e um pet");
            spam.show();
        }
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/TelaAgendamento.fxml"));
            painelServico.getChildren().setAll(menuInicial);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void transferirInfo(String dataAgendada, String horaAgendada){
        hora = horaAgendada;
        data = dataAgendada;

        lblAgenda.setText("Agendamento pro dia "+data+" às "+hora+"h");

    }
}
