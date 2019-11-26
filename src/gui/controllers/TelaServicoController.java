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
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;
import negocio.excecoes.ClienteInexistenteException;
import negocio.excecoes.ClienteJaCadastradoException;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaServicoController implements Initializable {

    @FXML
    private Pane painelServico;
    @FXML
    private Label lblServico;
    @FXML
    private TextField inputBuscarCpf;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<PetCliente> tbView;
    @FXML
    private TableColumn<?, ?> nomePet;
    @FXML
    private TableColumn<?, ?> nomeSexo;
    @FXML
    private TableColumn<?, ?> nomeEspecie;
    @FXML
    private Label lblvalorTotal;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO


        //      teste
        ArrayList<PetCliente> pets = new ArrayList<>();
        pets.add(new PetCliente("hulk", "cachorro", "macho"));
        pets.add(new PetCliente("layla", "gata", "femea"));

        try {
            ProjetoPoo.petShop.cadastrarCliente("Joao ", "702839", "81994905", pets);
        } catch (ClienteJaCadastradoException e) {
            System.out.println("erro");
        }
        // fim teste
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputBuscarCpf.getLength()>0){
            try{
                Cliente cliente = ProjetoPoo.petShop.consultarCliente(inputBuscarCpf.getText());
                System.out.println(cliente.getCpf());
                for (PetCliente pet: cliente.getPets()){
                    tbView.getItems().add(pet);
                }
            } catch (ClienteInexistenteException e) {
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
            }
        }
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../views/TelaAgendamento.fxml"));
            painelServico.getChildren().setAll(menuInicial);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void transferirHorarioEscolhido(String data, String hora){
        System.out.println(data + hora);
    }
}
