/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaCadastroPetsController implements Initializable {

    @FXML
    private Pane painelCadastroPets;
    @FXML
    private TextField inputSexo;
    @FXML
    private TextField inputPreco;
    @FXML
    private TextField inputEspecie;
    @FXML
    private TextField inputPeso;
    @FXML
    private TextField inputTamanho;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private DatePicker dataNascimento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void sexoInputHandler(ActionEvent event) {
    }

    @FXML
    private void precoInputHandler(ActionEvent event) {
    }

    @FXML
    private void especieInputHandler(ActionEvent event) {
    }

    @FXML
    private void pesoInputHandler(ActionEvent event) {
    }

    @FXML
    private void tamanhoInputHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane cadastro;
        try {
            cadastro = FXMLLoader.load(getClass().getResource("../views/TelaCadastro.fxml"));
            painelCadastroPets.getChildren().setAll(cadastro);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void dataNascimentoHandler(ActionEvent event) {
    }

}
