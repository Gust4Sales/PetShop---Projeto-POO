package gui.controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.controllers.MenuInicialController;
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
public class TelaVendaController implements Initializable {

    @FXML
    private Button btnVendaPets;
    @FXML
    private Button btnVendaProdutos;
    @FXML
    private Button btnVoltar;
    @FXML
    private Pane painel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vendaProdutosHandler(ActionEvent event) {
        Pane vendaPet;

        try {
            vendaPet = FXMLLoader.load(getClass().getResource("../views/TelaVendaProdutos.fxml"));
            painel.getChildren().setAll(vendaPet);

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
    @FXML
    private void vendaPetsHandler(ActionEvent event) {
        Pane vendaPet;
        try {
            vendaPet = FXMLLoader.load(getClass().getResource("../views/TelaVendaPets.fxml"));
            painel.getChildren().setAll(vendaPet);

        } catch (IOException ex) {
            System.out.println("qualquer coisa");

        }
    }

    @FXML
    private void voltarHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/MenuInicial.fxml"));
            painel.getChildren().setAll(menuInicial);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
