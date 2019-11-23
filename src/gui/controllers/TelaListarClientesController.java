/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaListarClientesController implements Initializable {

    @FXML
    private Pane painelBuscarCliente;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField inputBuscar;
    @FXML
    private TableView<?> tbCliente;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> cpfInput;
    @FXML
    private TableColumn<?, ?> telefoneInput;
    @FXML
    private TableView<?> tbPetCliente;
    @FXML
    private TableColumn<?, ?> nomePetInput;
    @FXML
    private TableColumn<?, ?> especieInput;
    @FXML
    private TableColumn<?, ?> sexoInput;
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void buscarInput(ActionEvent event) {
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        {
            Pane listarClientes;
            try {
                listarClientes = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
                painelBuscarCliente.getChildren().setAll(listarClientes);

            } catch (IOException ex) {
                Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
