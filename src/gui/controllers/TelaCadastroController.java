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
public class TelaCadastroController implements Initializable {

    @FXML
    private Pane painelCadastro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastraPetBtnHandler(ActionEvent event) {
        Pane cadastroPet;
        try {
            cadastroPet = FXMLLoader.load(getClass().getResource("../views/TelaCadastroPets.fxml"));
            painelCadastro.getChildren().setAll(cadastroPet);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void cadastraProdutoBtnHandler(ActionEvent event) {
        Pane cadastroProduto;
        try {
            cadastroProduto = FXMLLoader.load(getClass().getResource("../views/TelaCadastroProduto.fxml"));
            painelCadastro.getChildren().setAll(cadastroProduto);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }
    @FXML
    private void cadastrarClienteBtnHandler(ActionEvent event){
        Pane cadastroPet;
        try {
            cadastroPet = FXMLLoader.load(getClass().getResource("../views/TelaCadastroClientes.fxml"));
            painelCadastro.getChildren().setAll(cadastroPet);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/MenuInicial.fxml"));
            painelCadastro.getChildren().setAll(menuInicial);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
