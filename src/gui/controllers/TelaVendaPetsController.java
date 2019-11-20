/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.Pane;
import negocio.entidades.PetPetshop;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaVendaPetsController implements Initializable {

    @FXML
    private TableView<PetPetshop> tbView;
    @FXML
    private TextField inputId;
    @FXML
    private TableColumn<PetPetshop, String> tbEspecie;
    @FXML
    private TableColumn<PetPetshop, String> tbSexo;
    @FXML
    private TableColumn<PetPetshop, String> tbDataDeNascimento;
    @FXML
    private TableColumn<PetPetshop, String> tbPeso;
    @FXML
    private TableColumn<PetPetshop, String> tbTamanho;
    @FXML
    private TableColumn<PetPetshop, Double> tbPreco;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Pane painelVendaPets;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane venda;
        try {
            venda = FXMLLoader.load(getClass().getResource("../views/TelaVenda.fxml"));
            painelVendaPets.getChildren().setAll(venda);

        } catch (IOException ex) {
            System.out.println("qualquer coisa");

        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputId.getText().length() > 0){
            System.out.println(inputId.getText());
            preencherTabela();
        } else {
            tbView.setItems(null);
        }
    }

    private void preencherTabela () {
        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        tbDataDeNascimento.setCellValueFactory(
                new PropertyValueFactory<>("DataNascimento"));
        tbPeso.setCellValueFactory(
                new PropertyValueFactory<>("Peso"));
        tbSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));
        tbTamanho.setCellValueFactory(
                new PropertyValueFactory<>("Tamanho"));
        tbPreco.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));

        tbView.setItems(petInfo());
    }

    private ObservableList<PetPetshop> petInfo() {
        // Classe pet apenas para teste
        PetPetshop pet = new PetPetshop("cachorro", "44", "macho", "15/11", 15, 1.5, 200.00);
        return FXCollections.observableArrayList(pet);
    }

}
