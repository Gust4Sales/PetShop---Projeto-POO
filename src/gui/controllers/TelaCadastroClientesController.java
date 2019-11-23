/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaCadastroClientesController implements Initializable {
    ObservableList<String> choicesList = FXCollections.observableArrayList("Macho", "Fêmea");

    @FXML
    private Pane painelCadastroClientes;
    @FXML
    private ChoiceBox choiceSexo;
    @FXML
    private TextField inputNome;
    @FXML
    private TextField inputCpf;
    @FXML
    private TextField inputTelefone;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField inputNomePet;
    @FXML
    private TextField inputEspecie;
    @FXML
    private TextField inputSexo;
    @FXML
    private Button btnConfirmarPet;
    @FXML
    private TableView<?> tbView;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbEspecie;
    @FXML
    private TableColumn<?, ?> tbSexo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceSexo.setItems(choicesList);
        // TODO
    }

    @FXML
    private void nomeInputHandler(ActionEvent event) {
    }

    @FXML
    private void cpfInputHandler(ActionEvent event) {
    }

    @FXML
    private void telefoneInputHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane cadastro;
        try {
            cadastro = FXMLLoader.load(getClass().getResource("../views/TelaCadastro.fxml"));
            painelCadastroClientes.getChildren().setAll(cadastro);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    @FXML
    private void nomePetInputHandler(ActionEvent event) {
    }

    @FXML
    private void EspecieInputHandler(ActionEvent event) {
    }

    @FXML
    private void SexoInputHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarPetBtnHandler(ActionEvent event) {
    }

//    private void addSexo(ChoiceBox choiceSexo) {

 //   }
}
