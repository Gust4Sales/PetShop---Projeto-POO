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
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaListarVendaPetsController implements Initializable {
    @FXML
    private Pane painelHistoricoPets;
    @FXML
    private DatePicker dateSalePets;
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
    private TableColumn<?, ?> tbDataDeNasc;
    @FXML
    private TableColumn<?, ?> tbPeso;
    @FXML
    private TableColumn<?, ?> tbTam;
    @FXML
    private TableColumn<?, ?> tbPreco;
    @FXML
    private TableColumn<?, ?> tbDataVenda;
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
    private void salePetsDateHandler(ActionEvent event) {
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane historicoPets;
        try {
            historicoPets = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
            painelHistoricoPets.getChildren().setAll(historicoPets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


