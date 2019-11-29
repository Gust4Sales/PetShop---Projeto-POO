/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.consultas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import PetShop.ProjetoPoo;
import PetShop.gui.controllers.MenuInicialController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.entidades.PetCliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaListarClientesController implements Initializable {
    private Alert spam;

    @FXML
    private Pane painelBuscarCliente;
    @FXML
    private TextField inputBuscar;
    @FXML
    private TableView<Cliente> tbCliente;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbCpf;
    @FXML
    private TableColumn<?, ?> tbTel;
    @FXML
    private TableView<PetCliente> tbPetCliente;
    @FXML
    private TableColumn<?, ?> tbNomePet;
    @FXML
    private TableColumn<?, ?> tbEspecie;
    @FXML
    private TableColumn<?, ?> tbSexo;

    public TelaListarClientesController(){
        spam = new Alert(Alert.AlertType.NONE);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbNome.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbTel.setCellValueFactory(
                new PropertyValueFactory<>("Telefone"));
        tbCpf.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));
        tbNomePet.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("especie"));
        tbSexo.setCellValueFactory(
                new PropertyValueFactory<>("sexo"));
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        tbCliente.getItems().clear();
        tbPetCliente.getItems().clear();
        if (inputBuscar.getLength()>0){
            try{
                Cliente cliente = ProjetoPoo.petShop.consultarCliente(inputBuscar.getText());
                ArrayList<PetCliente> pets = cliente.getPets();

                tbCliente.getItems().clear();
                tbPetCliente.getItems().clear();

                tbCliente.getItems().add(cliente);
                for (PetCliente pet:pets){
                    tbPetCliente.getItems().add(pet);
                }

            } catch (ClienteInexistenteException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();
                tbCliente.getItems().clear();
                tbPetCliente.getItems().clear();
            }
        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {

        Pane listarClientes;
        try {
            listarClientes = FXMLLoader.load(getClass().getResource("../../views/consultas/TelaListar.fxml"));
            painelBuscarCliente.getChildren().setAll(listarClientes);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
