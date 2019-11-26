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
import negocio.entidades.ServicoCompleto;
import negocio.excecoes.ClienteInexistenteException;
import negocio.excecoes.ClienteJaCadastradoException;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaServicoController implements Initializable {
    private Alert spam;

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


        //      teste
        ArrayList<PetCliente> pets = new ArrayList<>();
        pets.add(new PetCliente("hulk", "cachorro", "macho"));
        pets.add(new PetCliente("layla", "gata", "femea"));

        try {
            ProjetoPoo.petShop.cadastrarCliente("Joao ", "702839", "81994905", pets);
        } catch (ClienteJaCadastradoException e) {
            System.out.println("erro");
        }

    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputBuscarCpf.getLength()>0){
            try{
                Cliente cliente = ProjetoPoo.petShop.consultarCliente(inputBuscarCpf.getText());

                tbView.getItems().clear();
                for (PetCliente pet: cliente.getPets()){
                    tbView.getItems().add(pet);
                }
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

    void transferirInfo(String data, String hora){
        System.out.println(data + hora);

        lblAgenda.setText("Agendamento pro dia "+data+" às "+hora+"h");

    }
}
