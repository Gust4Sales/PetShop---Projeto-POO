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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaAlterarClientesController implements Initializable {

    @FXML
    private TableView<?> tbView;
    @FXML
    private Pane painelAlterar;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbEspecie;
    @FXML
    private TableColumn<?, ?> tbSexo;
    @FXML
    private TextField inputNomePet;
    @FXML
    private TextField inputEspecie;
    @FXML
    private TextField inputSexo;
    @FXML
    private Button btnConfirmarPet;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField inputAlteraCpf;
    @FXML
    private TextField inputAlteraTell;
    @FXML
    private Label alterarInformacoes;
    @FXML
    private Button btnTrocarTell;
    @FXML
    private Button btnRemover;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void voltarBtnHandler(ActionEvent event) {
        {
            Pane telaCadastro;
            try {
                 telaCadastro= FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
                painelAlterar.getChildren().setAll(telaCadastro);

            } catch (IOException ex) {
                Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void buscarCpfBtnHandler(ActionEvent event) {
    }

    @FXML
    private void alteraCpfInputHandler(ActionEvent event) {
    }

    @FXML
    private void alteraTellInputHandler(ActionEvent event) {
    }

    @FXML
    private void trocarTellBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cadastrarNovoPetBtnHandler(ActionEvent event) {
    }

    @FXML
    private void removerBtnHandler(ActionEvent event) {
    }

}
