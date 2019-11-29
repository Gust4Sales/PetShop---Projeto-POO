/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.ProjetoPoo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;
import negocio.excecoes.ClienteInexistenteException;
import negocio.excecoes.ClienteJaCadastradoException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaAlterarClientesController implements Initializable{
    private Alert spam;
    private Cliente cliente;

    @FXML
    private TableView<PetCliente> tbView;
    @FXML
    private Pane painelAlterar;
    @FXML
    private ChoiceBox<String> choiceSexo;
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
    private TextField inputCpf;
    @FXML
    private TextField inputAlteraTell;
    @FXML
    private Label alterarInformacoes;
    @FXML
    private Button btnTrocarTell;
    @FXML
    private Button btnRemover;

    public TelaAlterarClientesController(){
        spam = new Alert(Alert.AlertType.NONE);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> choicesList = FXCollections.observableArrayList("Macho", "Fêmea");

        choiceSexo.setValue(null);
        choiceSexo.setItems(choicesList);

        tbNome.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        tbSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));

        //Teste
        ArrayList<PetCliente> pets = new ArrayList<>();
        pets.add(new PetCliente("hulk", "dog", "macho"));
        pets.add(new PetCliente("layla", "dog", "femea"));
        try{
            ProjetoPoo.petShop.cadastrarCliente("Joao", "702", "8199490", pets);
        } catch (ClienteJaCadastradoException e) {
            System.out.println("cadastradndo de novo");
        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane telaCadastro;
        try {
            telaCadastro= FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
            painelAlterar.getChildren().setAll(telaCadastro);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void buscarCpfBtnHandler(ActionEvent event) {
        if (inputCpf.getLength()>0){
            try{
                cliente = ProjetoPoo.petShop.consultarCliente(inputCpf.getText());
                ArrayList<PetCliente> pets = cliente.getPets();

                tbView.getItems().clear();
                btnTrocarTell.setDisable(false);
                btnRemover.setDisable(false);
                btnConfirmarPet.setDisable(false);
                inputAlteraTell.setText(cliente.getTelefone());
                for (PetCliente pet: pets){
                    tbView.getItems().add(pet);
                }

            } catch (ClienteInexistenteException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();

                tbView.getItems().clear();
                inputEspecie.setText("");
                inputNomePet.setText("");
                choiceSexo.setValue(null);
                btnRemover.setDisable(true);
                btnTrocarTell.setDisable(true);
                btnConfirmarPet.setDisable(true);
                inputAlteraTell.setText("");
            }

        } else {
            tbView.getItems().clear();
            inputAlteraTell.setText("");
            inputEspecie.setText("");
            inputNomePet.setText("");
            choiceSexo.setValue(null);
            btnRemover.setDisable(true);
            btnTrocarTell.setDisable(true);
            btnConfirmarPet.setDisable(true);
        }
    }

    @FXML
    private void trocarTellBtnHandler(ActionEvent event) {
        String telefone = inputAlteraTell.getText();

        if (inputAlteraTell.getLength()>0){
            if (!telefone.equals(cliente.getTelefone())){
                ProjetoPoo.petShop.atualizarTelefoneCliente(cliente, telefone);

                spam.setAlertType(Alert.AlertType.INFORMATION);
                spam.setContentText("Telefone alterado com sucesso!");
                spam.show();
            }
        }
    }

    @FXML
    private void cadastrarNovoPetBtnHandler(ActionEvent event) {
        String especie = inputEspecie.getText();
        String nomePet = inputNomePet.getText();

        if (especie.length()>0 && nomePet.length()>0 && choiceSexo.getValue()!=null){
            String sexo = choiceSexo.getValue();

            PetCliente pet = new PetCliente(nomePet, especie, sexo);
            List<PetCliente> petsTemp= tbView.getItems();
            ArrayList<PetCliente> pets = new ArrayList<>(petsTemp);
            pets.add(pet);

            ProjetoPoo.petShop.alterarPetsCliente(cliente, pets);

            inputEspecie.setText("");
            inputNomePet.setText("");
            choiceSexo.setValue(null);
            tbView.getItems().add(pet);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Novo pet cadastrado com sucesso!");
            spam.show();
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Preencha todas as informações do pet!");
            spam.show();
        }
    }

    @FXML
    private void removerBtnHandler(ActionEvent event) {
        PetCliente pet = tbView.getSelectionModel().getSelectedItem();
        if (pet!=null){
            tbView.getItems().remove(pet);

            List<PetCliente> petsTemp= tbView.getItems();
            ArrayList<PetCliente> pets = new ArrayList<>(petsTemp);

            ProjetoPoo.petShop.alterarPetsCliente(cliente, pets);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Pet removido com sucesso!");
            spam.show();
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um pet!");
            spam.show();
        }
    }


}
