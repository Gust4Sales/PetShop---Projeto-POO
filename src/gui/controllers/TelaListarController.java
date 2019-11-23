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
    @FXML
    private Button btnListaVendaPets;
    @FXML
    private Button btnListaVendaProdutos;
    @FXML
    private Button btnListaClientes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void listarEstoquePetsBtnHandler(ActionEvent event) {

        Pane listarPets;

        try {
            listarPets = FXMLLoader.load(getClass().getResource("../views/TelaListarPets.fxml"));
            painelListar.getChildren().setAll(listarPets);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void listarEstoqueProdutosBtnHandler(ActionEvent event) {
        Pane listar;
        try {
            listar = FXMLLoader.load(getClass().getResource("../views/TelaListarProdutos.fxml"));
            painelListar.getChildren().setAll(listar);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void listarHistoricoBtnHandler(ActionEvent event) {
        Pane historico;
        try {
            historico = FXMLLoader.load(getClass().getResource("../views/TelaListarHistoricoServico.fxml"));
            painelListar.getChildren().setAll(historico);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @FXML
    private void listaVendaPetsBtnHandler(ActionEvent event) {
        Pane historicoDeVendas;

        try {
            historicoDeVendas = FXMLLoader.load(getClass().getResource("../views/TelaListarVendaPets.fxml"));
            painelListar.getChildren().setAll(historicoDeVendas);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void listaVendaProdutosBtnHandler(ActionEvent event) {
        Pane historicoDeVendas;

        try {
            historicoDeVendas = FXMLLoader.load(getClass().getResource("../views/TelaListarVendaDeProdutos.fxml"));
            painelListar.getChildren().setAll(historicoDeVendas);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void listaClientesBtnHandler(ActionEvent event) {
        Pane listarClientes;

        try {
            listarClientes = FXMLLoader.load(getClass().getResource("../views/TelaListarCliente.fxml"));
            painelListar.getChildren().setAll(listarClientes);

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

}
