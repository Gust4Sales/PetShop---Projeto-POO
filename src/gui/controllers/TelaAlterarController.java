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
public class TelaAlterarController implements Initializable {

    @FXML
    private Pane painelAlterar;
    @FXML
    private Button btnAlterarCliente;
    @FXML
    private Button btnAlterarProduto;
    @FXML
    private Button btnPetPetshop;
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
    private void alterarClienteBtnHandler(ActionEvent event) {
        Pane alterarClientes;
        try {

            alterarClientes = FXMLLoader.load(getClass().getResource("../views/TelaAlterarCliente.fxml"));
            painelAlterar.getChildren().setAll(alterarClientes);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void alterarProdutoBtnHandler(ActionEvent event) {
        Pane alterarPets;
        try {
            alterarPets = FXMLLoader.load(getClass().getResource("../views/TelaAlterarProdutos.fxml"));
            painelAlterar.getChildren().setAll(alterarPets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void alterarPetPetshopBtnHandler(ActionEvent event) {
        Pane alterarPets;
        try {
            alterarPets = FXMLLoader.load(getClass().getResource("../views/TelaAlterarPets.fxml"));
            painelAlterar.getChildren().setAll(alterarPets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/MenuInicial.fxml"));
            painelAlterar.getChildren().setAll(menuInicial);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
