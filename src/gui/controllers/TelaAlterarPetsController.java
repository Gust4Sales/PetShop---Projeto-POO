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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaAlterarPetsController implements Initializable {
    @FXML
    private Pane painelAlterarPets;
    @FXML
    private TextField inputId;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<?> tbView;
    @FXML
    private TableColumn<?, ?> tbId;
    @FXML
    private TableColumn<?, ?> tbEspecie;
    @FXML
    private TableColumn<?, ?> tbSexo;
    @FXML
    private TableColumn<?, ?> tbPeso;
    @FXML
    private TableColumn<?, ?> tbTamanho;
    @FXML
    private TableColumn<?, ?> tbPreco;
    @FXML
    private TextField inputPeso;
    @FXML
    private TextField inputTamanho;
    @FXML
    private TextField inputPreco;
    @FXML
    private Button btnRemoverPet;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void idInputHandler(ActionEvent event) {
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void pesoInputHandler(ActionEvent event) {
    }

    @FXML
    private void tamanhoInputHandler(ActionEvent event) {
    }

    @FXML
    private void PrecoInputHandler(ActionEvent event) {
    }

    @FXML
    private void removerPetBtnHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        {
            Pane alterar;
            try {
                alterar = FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
                painelAlterarPets.getChildren().setAll(alterar);

            } catch (IOException ex) {
                Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
