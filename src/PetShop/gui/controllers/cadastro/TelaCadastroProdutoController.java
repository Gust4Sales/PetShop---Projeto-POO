/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.cadastro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import PetShop.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import PetShop.negocio.excecoes.ProdutoJaCadastradoException;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaCadastroProdutoController implements Initializable {

    @FXML
    private TextField inputID;
    @FXML
    private Pane painelCadastroProdutos;
    @FXML
    private TextField inputDigiteNome;
    @FXML
    private TextField inputDigiteMarca;
    @FXML
    private TextField inputDigiteQtd;
    @FXML
    private TextField inputDigitePreco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
        verificarCampos();
    }

    private void verificarCampos(){
        String nome = inputDigiteNome.getText();
        String marca = inputDigiteMarca.getText();
        String id = inputID.getText();
        String qtd = inputDigiteQtd.getText();
        String preco = inputDigitePreco.getText();
        boolean validados;

        if ((nome.length()>0) && (marca.length()>0) && (id.length()>0) && (qtd.length()>0) &&
                (preco.length()>0)){
            validados = validarDados();

            if (validados){
                preco = inputDigitePreco.getText();
                qtd = inputDigiteQtd.getText();
                try {
                    ProjetoPoo.petShop.cadastrarProduto(nome, marca, Double.parseDouble(preco), id,
                            Integer.parseInt(qtd));

                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.setContentText("Produto cadastrado com sucesso!");
                    a.show();

                    limparCampos();
                } catch (ProdutoJaCadastradoException e){
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText(e.getMessage());
                    a.show();
                }
            }
        }else {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Preencha todos os campos!");
            a.show();
        }

    }

    private boolean validarDados(){
        String preco = inputDigitePreco.getText();
        String qtd = inputDigiteQtd.getText();
        boolean erro = false;

        try{
            if (preco.contains(",")){
                inputDigitePreco.setText(preco.replace(",", "."));
                Double.parseDouble(inputDigitePreco.getText());
            } else{
                Double.parseDouble(preco);
            }
        } catch (Exception e){
            erro = true;
            inputDigitePreco.setText("");
        }

        try{
            Integer.parseInt(inputDigiteQtd.getText());
        } catch (Exception e){
            erro = true;
            inputDigiteQtd.setText("");
        }

        if (erro){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Campos inseridos incorretamente!");
            a.show();
            return false;
        } else {
            return true;
        }

    }

    private void limparCampos(){
        inputDigitePreco.setText("");
        inputDigiteMarca.setText("");
        inputDigiteNome.setText("");
        inputDigiteQtd.setText("");
        inputID.setText("");
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane cadastro;
        try {
            cadastro = FXMLLoader.load(getClass().getResource("../../views/cadastro/TelaCadastro.fxml"));
            painelCadastroProdutos.getChildren().setAll(cadastro);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
