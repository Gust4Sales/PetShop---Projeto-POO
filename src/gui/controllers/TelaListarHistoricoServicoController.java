/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaListarHistoricoServicoController implements Initializable {
    @FXML
    private Pane painelListaServico;
    @FXML
    private TextField inputCpf;
    @FXML
    private DatePicker dateSearch;
    @FXML
    private Button btnBuscarCpf;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbCpf;
    @FXML
    private TableColumn<?, ?> tbTipoServico;
    @FXML
    private TableColumn<?, ?> tbPet;
    @FXML
    private TableColumn<?, ?> tbData;
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
    private void cpfInputHandler(ActionEvent event) {
    }

    @FXML
    private void searchDateHandler(ActionEvent event) {
    }

    @FXML
    private void cpfBuscarHandler(ActionEvent event) {
    }

    @FXML
    private void bsucarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane listar;
        try {
            listar = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
            painelListaServico.getChildren().setAll(listar);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

}
