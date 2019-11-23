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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaListarVendaDeProdutosController implements Initializable {

    @FXML
    private Pane painelHistoricoVendas;
    @FXML
    private TableColumn<?, ?> tbId;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbMarca;
    @FXML
    private TableColumn<?, ?> tbQuantidade;
    @FXML
    private TableColumn<?, ?> tbPreço;
    @FXML
    private TableColumn<?, ?> tbDataDeVenda;
    @FXML
    private Button btnBucar;
    @FXML
    private DatePicker dateBuscarHistorico;
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
    private void buscarDateHandler(ActionEvent event) {
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane historicoVendas;
        try {
            historicoVendas = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
            painelHistoricoVendas.getChildren().setAll(historicoVendas);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }


