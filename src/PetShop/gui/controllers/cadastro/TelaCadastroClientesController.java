/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.cadastro;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import PetShop.ProjetoPoo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.PetCliente;
import PetShop.negocio.excecoes.ClienteJaCadastradoException;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaCadastroClientesController implements Initializable {
    private Alert spam;
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
    private TextField inputNomePet;
    @FXML
    private TextField inputEspecie;
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
        spam = new Alert(Alert.AlertType.NONE);
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
    private void confirmarBtnHandler(ActionEvent event) {
        String nome = inputNome.getText();
        String cpf = inputCpf.getText();
        String tel = inputTelefone.getText();

        if (nome.length()>0 && cpf.length()>0 && tel.length()>0){
            List<PetCliente> petsTemp= tbView.getItems();
            ArrayList<PetCliente> pets = new ArrayList<>(petsTemp);

            try {
                ProjetoPoo.petShop.cadastrarCliente(nome, cpf, tel, pets);

                spam.setAlertType(Alert.AlertType.INFORMATION);
                spam.setContentText("Cliente cadastrado com sucesso!");
                spam.show();

                inputTelefone.setText("");
                inputNome.setText("");
                inputCpf.setText("");
                tbView.getItems().clear();
                btnConfirmar.setDisable(true);
            } catch (ClienteJaCadastradoException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();
            }
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Preencha todas as informações do cliente");
            spam.show();
        }
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane cadastro;
        try {
            cadastro = FXMLLoader.load(getClass().getResource("../../views/cadastro/TelaCadastro.fxml"));
            painelCadastroClientes.getChildren().setAll(cadastro);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
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
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Preencha todas as informações do pet!");
            spam.show();
        }
    }

}
