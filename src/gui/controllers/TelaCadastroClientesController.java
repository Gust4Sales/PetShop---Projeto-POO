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
import negocio.entidades.PetCliente;
import negocio.entidades.PetPetshop;
import negocio.excecoes.ClienteJaCadastradoException;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaCadastroClientesController implements Initializable {
    private ObservableList<String> choicesList;

    @FXML
    private Pane painelCadastroClientes;
    @FXML
    private ChoiceBox<String> choiceSexo;
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
    private TableView<PetCliente> tbView;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbEspecie;
    @FXML
    private TableColumn<?, ?> tbSexo;

    /**
     * Initializes the controller class.
     */
    public TelaCadastroClientesController(){
        choicesList = FXCollections.observableArrayList("Macho", "Fêmea");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceSexo.setItems(choicesList);

        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));

        tbNome.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        tbSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));
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
        String nome = inputNome.getText();
        String cpf = inputCpf.getText();
        String tel = inputTelefone.getText();

        if (nome.length()>0 && cpf.length()>0 && tel.length()>0){
            List<PetCliente> petsTemp= tbView.getItems();
            ArrayList<PetCliente> pets = new ArrayList<>();
            for (PetCliente p : petsTemp){
                pets.add(p);
            }
            try {
                ProjetoPoo.petShop.cadastrarCliente(nome, cpf, tel, pets);

                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Cliente cadastrado com sucesso!");
                a.show();

                inputTelefone.setText("");
                inputNome.setText("");
                inputCpf.setText("");
                tbView.getItems().clear();
                btnConfirmar.setDisable(true);
            } catch (ClienteJaCadastradoException e) {
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Preencha todas as informações do cliente");
            a.show();
        }
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
        String especie = inputEspecie.getText();
        String nomePet = inputNomePet.getText();

        if (especie.length()>0 && nomePet.length()>0 && choiceSexo.getValue()!=null){
            String sexo = choiceSexo.getValue();
            PetCliente pet = new PetCliente(nomePet, especie, sexo);

            inputEspecie.setText("");
            inputNomePet.setText("");
            choiceSexo.setValue(null);
            tbView.getItems().add(pet);

            btnConfirmar.setDisable(false);
        } else {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Preencha todas as informações do pet!");
            a.show();
        }
    }

//    private void addSexo(ChoiceBox choiceSexo) {

 //   }
}
