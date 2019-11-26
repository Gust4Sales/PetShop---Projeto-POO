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

import gui.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.entidades.PetPetshop;
import negocio.excecoes.PetPetshopInexistenteException;
import negocio.excecoes.PetPetshopJaCadastradoException;
import negocio.excecoes.ProdutoInexistenteException;
import negocio.excecoes.QuantidadeInvalidaException;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaAlterarPetsController implements Initializable {
    private PetPetshop ultimoPetPetshopPesquisado;
    @FXML
    private Pane painelAlterarPets;
    @FXML
    private TextField inputId;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<PetPetshop> tbView;
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
    private TableColumn<?, ?> tbPreco;
    @FXML
    private TextField inputPeso;
    @FXML
    private TextField inputTamanho;
    @FXML
    private TextField inputPreco;
    @FXML
    private Button btnRemoverPet;
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
        tbPreco.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));
        try {
            ProjetoPoo.petShop.cadastrarPetPetshop("cachorro", "1", "macho", "21/10/2015", 54.21, 78.52, 50);
        } catch (PetPetshopJaCadastradoException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void idInputHandler(ActionEvent event) {
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputId.getText().length() > 0){
            try{
                ultimoPetPetshopPesquisado = ProjetoPoo.petShop.consultarPetPetshop(inputId.getText());

                tbView.getItems().clear();
                tbView.getItems().add(ultimoPetPetshopPesquisado); // Insere produto na Tabela de visualizacao
                btnRemoverPet.setDisable(false);
                btnConfirmar.setDisable(false);
            } catch (PetPetshopInexistenteException e){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
                inputId.setText("");
                tbView.getItems().clear();
                btnRemoverPet.setDisable(true);
                btnConfirmar.setDisable(true);
            }
        } else {
            inputId.setText("");
            tbView.getItems().clear();
            btnRemoverPet.setDisable(true);
            btnConfirmar.setDisable(true);
        }
    }

    @FXML
    private void pesoInputHandler(ActionEvent event) {
    }

    @FXML
    private void tamanhoInputHandler(ActionEvent event) {
    }

    @FXML
    private void PrecoInputHandler(ActionEvent event) {
    }

    @FXML
    private void removerPetBtnHandler(ActionEvent event) throws PetPetshopInexistenteException {
        tbView.getItems().clear();

        ProjetoPoo.petShop.venderPetPetshop(ultimoPetPetshopPesquisado.getId());

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("Pet removido com sucesso!");
        a.show();

        inputId.setText("");
        btnRemoverPet.setDisable(true);
        btnConfirmar.setDisable(true);
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) throws PetPetshopInexistenteException {
        //boolean erro = false;

        if (inputPreco.getLength()==0 && inputPeso.getLength()==0 && inputTamanho.getLength()==0){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.NONE);
            a.setContentText("Insira pelo menos uma alteração");
            a.show();
        } else{
            boolean precoValidado = validarPreco();
            boolean tamanhoValidado = validarTamanho();
            boolean pesoValidado = validarPeso();

            if (!(precoValidado && tamanhoValidado && pesoValidado)){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Um ou mais campos inseridos incorretamente");
                a.show();
                return;
            }

            alterarPetPetshop();
        }
    }


    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        {
            Pane alterar;
            try {
                alterar = FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
                painelAlterarPets.getChildren().setAll(alterar);

            } catch (IOException ex) {
                Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private boolean validarPreco() {
        String preco = inputPreco.getText();

        if (preco.length() > 0) {
            try {
                if (preco.contains(",")) {
                    inputPreco.setText(preco.replace(",", "."));
                    Double.parseDouble(inputPreco.getText());
                } else {
                    Double.parseDouble(preco);
                }
                return true;
            } catch (Exception e) {
                inputPreco.setText("");
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean validarTamanho(){
        String tamanho = inputTamanho.getText();

        if (tamanho.length()>0) {
            try {
                if (tamanho.contains(",")) {
                    inputTamanho.setText(tamanho.replace(",", "."));
                    Double.parseDouble(inputTamanho.getText());
                } else {
                    Double.parseDouble(tamanho);
                }
                return true;
            } catch (Exception e) {

                inputTamanho.setText("");
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean validarPeso(){
        String peso = inputPeso.getText();

        if (peso.length()>0) {
            try {
                if (peso.contains(",")) {
                    inputPeso.setText(peso.replace(",", "."));
                    Double.parseDouble(inputPeso.getText());
                } else {
                    Double.parseDouble(peso);
                }
                return true;
            } catch (Exception e) {
                inputPeso.setText("");
                return false;
            }
        } else {
            return true;
        }
    }

    private void alterarPetPetshop() throws PetPetshopInexistenteException {
        String id = ultimoPetPetshopPesquisado.getId();
        double peso;
        double tam;
        double preco;

        if (inputPreco.getLength()>0){
            preco = Double.parseDouble(inputPreco.getText());
        } else {
            preco = ultimoPetPetshopPesquisado.getPreco();
        }
        if(inputTamanho.getLength()>0){
            tam = Double.parseDouble(inputTamanho.getText());
        } else{
            tam = ultimoPetPetshopPesquisado.getTamanho();
        }
        if(inputPeso.getLength()>0){
            peso = Double.parseDouble(inputPeso.getText());
        } else{
            peso = ultimoPetPetshopPesquisado.getPeso();
        }
        ProjetoPoo.petShop.atualizarPetPetshop(id,tam,peso,preco);

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("Pet alterado com sucesso!");
        a.show();

        tbView.getItems().clear();
        inputPeso.setText("");
        inputPreco.setText("");
        inputTamanho.setText("");
        tbView.getItems().add(ultimoPetPetshopPesquisado);



    }

}
