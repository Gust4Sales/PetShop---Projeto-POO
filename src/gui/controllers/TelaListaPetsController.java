/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.entidades.PetPetshop;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaListaPetsController implements Initializable {

    @FXML
    private Pane painelEstoquePets;
    @FXML
    private TableView<PetPetshop> tbEstoquePets;
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
    private TableColumn<?, ?> tbDataDeNasciemento;
    @FXML
    private TableColumn<?, ?> tbPreço;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbId.setCellValueFactory(
                new PropertyValueFactory<>("Id"));
        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        tbSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));
        tbTamanho.setCellValueFactory(
                new PropertyValueFactory<>("Tamanho"));
        tbPeso.setCellValueFactory(
                new PropertyValueFactory<>("Peso"));
        tbDataDeNasciemento.setCellValueFactory(
                new PropertyValueFactory<>("dataNascimento"));
        tbPreço.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));

        ArrayList<PetPetshop> pets = ProjetoPoo.petShop.consultarPetsEstoque();

        for (PetPetshop pet: pets){
            tbEstoquePets.getItems().add(pet);
        }

    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane estoquePets;
        try {
            estoquePets = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
            painelEstoquePets.getChildren().setAll(estoquePets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}