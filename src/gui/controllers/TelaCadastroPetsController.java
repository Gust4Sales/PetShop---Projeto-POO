/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import gui.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaCadastroPetsController implements Initializable {

    @FXML
    private Pane painelCadastroPets;
    @FXML
    private TextField inputSexo;
    @FXML
    private TextField inputPreco;
    @FXML
    private TextField inputEspecie;
    @FXML
    private TextField inputPeso;
    @FXML
    private TextField inputTamanho;
    @FXML
    private TextField inputID;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private DatePicker dataNascimento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDate maxDate = LocalDate.now();
        dataNascimento.setDayCellFactory(d ->
                new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isAfter(maxDate));
                    }});
    }

    @FXML
    private void sexoInputHandler(ActionEvent event) {
    }

    @FXML
    private void especieInputHandler(ActionEvent event) {
    }

    @FXML
    private void pesoInputHandler(ActionEvent event) {
    }

    @FXML
    private void tamanhoInputHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
        // Try catch de ID invalido
        verificaCampos();

    }

    private void verificaCampos(){
        String especie = inputEspecie.getText();
        String id = inputID.getText();
        String peso = inputPeso.getText();
        String preco = inputPreco.getText();
        String tamanho = inputTamanho.getText();
        String sexo = inputSexo.getText();
        LocalDate data = dataNascimento.getValue();
        boolean validados;

        if ((especie.length()>0) && (peso.length() > 0) && (preco.length()>0) &&
                (tamanho.length()>0) && (id.length())>0 && (sexo.length()>0) && data!=null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataNasc = data.format(formatter);

            validados = validaDados();

            if (validados){
                preco = inputPreco.getText();
                peso = inputPeso.getText();
                tamanho = inputTamanho.getText();

                ProjetoPoo.petShop.cadastrarPetPetshop(especie, id, sexo, dataNasc, Double.parseDouble(peso),
                        Double.parseDouble(tamanho), Double.parseDouble(preco));
                // Id invalido throw erro
            }

        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }

    private boolean validaDados(){
        String preco = inputPreco.getText();
        String peso = inputPeso.getText();
        String tam = inputTamanho.getText();
        boolean erro = false;

        try{
            if (preco.contains(",")){
                inputPreco.setText(preco.replace(",", "."));
                Double.parseDouble(inputPreco.getText());
            } else{
                Double.parseDouble(preco);
            }
        } catch (Exception e){
            erro = true;
            inputPreco.setText("");
        }

        try{
            if (tam.contains(",")){
                inputTamanho.setText(tam.replace(",", "."));
                Double.parseDouble(inputTamanho.getText());
            } else {
                Double.parseDouble(tam);
            }
        } catch (Exception e){
            erro = true;
            inputTamanho.setText("");
        }

        try{
            if (peso.contains(",")){
                inputPeso.setText(peso.replace(",", "."));
                Double.parseDouble(inputPeso.getText());
            } else {
                Double.parseDouble(peso);
            }
        } catch (Exception e){
            erro = true;
            inputPeso.setText("");
        }

        if (erro){
            JOptionPane.showMessageDialog(null, "Campos inseridos incorretamente!");
            return false;
        } else {
            return true;
        }

    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane cadastro;
        try {
            cadastro = FXMLLoader.load(getClass().getResource("../views/TelaCadastro.fxml"));
            painelCadastroPets.getChildren().setAll(cadastro);

        } catch (IOException ex) {
            System.out.println(ex);


        }
    }

    @FXML
    private void dataNascimentoHandler(ActionEvent event) {
    }
    @FXML
    private void precoInputHandler(ActionEvent actionEvent) {
    }
}
