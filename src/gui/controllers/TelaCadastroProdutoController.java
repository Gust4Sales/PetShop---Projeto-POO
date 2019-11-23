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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaCadastroProdutoController implements Initializable {

    @FXML
    private TextField inputID;
    @FXML
    private Pane painelCadastroProdutos;
    @FXML
    private TextField inputDigiteNome;
    @FXML
    private TextField inputDigiteMarca;
    @FXML
    private TextField inputDigiteQtd;
    @FXML
    private TextField inputDigitePreço;
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
    private void digiteNomeInputHandler(ActionEvent event) {
    }

    @FXML
    private void digiteMarcaInputHandler(ActionEvent event) {
    }

    @FXML
    private void digiteQtdInputHandler(ActionEvent event) {
    }

    @FXML
    private void digitePrecoInputHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane cadastro;
        try {
            cadastro = FXMLLoader.load(getClass().getResource("../views/TelaCadastro.fxml"));
            painelCadastroProdutos.getChildren().setAll(cadastro);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

}
