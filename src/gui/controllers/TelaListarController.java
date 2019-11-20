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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaListarController implements Initializable {

    @FXML
    private Button btnListarEstoquePets;
    @FXML
    private Button btnListarEstoqueProdutos;
    @FXML
    private Button btnListarHistorico;
    @FXML
    private Button btnVoltar;
    @FXML
    private Pane painelListar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void listarEstoquePetsBtnHandler(ActionEvent event) {
    }

    @FXML
    private void listarEstoqueProdutosBtnHandler(ActionEvent event) {
    }

    @FXML
    private void listarHistoricoBtnHandler(ActionEvent event) {
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/MenuInicial.fxml"));
            painelListar.getChildren().setAll(menuInicial);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
