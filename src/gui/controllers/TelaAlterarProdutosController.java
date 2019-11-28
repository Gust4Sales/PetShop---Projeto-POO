/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.entidades.Produto;
import negocio.excecoes.ProdutoInexistenteException;
import negocio.excecoes.ProdutoJaCadastradoException;
import negocio.excecoes.QuantidadeInvalidaException;

/**
 * FXML Controller class
 *
 * @author 55819
 */
public class TelaAlterarProdutosController implements Initializable {
    private Produto ultimoProdutoPesquisado;
    private Alert spam;

    @FXML
    private Pane painelAlterarProdutos;
    @FXML
    private TextField inputId;
    @FXML
    private TableView<Produto> tbView;
    @FXML
    private TableColumn<?, ?> tbId;
    @FXML
    private TableColumn<?, ?> tbNome;
    @FXML
    private TableColumn<?, ?> tbMarca;
    @FXML
    private TableColumn<?, ?> tbQntd;
    @FXML
    private TableColumn<?, ?> tbPreco;
    @FXML
    private Button btnRemoverProduto;
    @FXML
    private TextField inputQntd;
    @FXML
    private TextField inputPreco;
    @FXML
    private Button btnConfirmar;

    public TelaAlterarProdutosController(){
        spam = new Alert(Alert.AlertType.NONE);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbId.setCellValueFactory(
                new PropertyValueFactory<>("Id"));
        tbNome.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbMarca.setCellValueFactory(
                new PropertyValueFactory<>("Marca"));
        tbQntd.setCellValueFactory(
                new PropertyValueFactory<>("Quantidade"));
        tbPreco.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));
    }


    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputId.getText().length() > 0){
            try{
                ultimoProdutoPesquisado = ProjetoPoo.petShop.consultarProduto(inputId.getText());

                tbView.getItems().clear();
                tbView.getItems().add(ultimoProdutoPesquisado); // Insere produto na Tabela de visualizacao
                btnRemoverProduto.setDisable(false);
                btnConfirmar.setDisable(false);
            } catch (ProdutoInexistenteException e){
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();

                inputId.setText("");
                tbView.getItems().clear();
                btnRemoverProduto.setDisable(true);
                btnConfirmar.setDisable(true);
            }
        } else {
            inputId.setText("");
            tbView.getItems().clear();
            btnRemoverProduto.setDisable(true);
            btnConfirmar.setDisable(true);
        }
    }

    @FXML
    private void removerProdutoBtnHandler(ActionEvent event) throws ProdutoInexistenteException {
        tbView.getItems().clear();
        try{
            ProjetoPoo.petShop.removerProduto(ultimoProdutoPesquisado.getId());

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Produto removido com sucesso!");
            spam.show();

        } catch (ProdutoInexistenteException e){
            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText(e.getMessage());
            spam.show();
        }

        inputId.setText("");
        btnRemoverProduto.setDisable(true);
        btnConfirmar.setDisable(true);
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) throws ProdutoInexistenteException {
        boolean erro = false;

        if (inputPreco.getLength() == 0 && inputQntd.getLength() == 0) {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Insira pelo menos uma alteração");
            spam.show();
        } else if (inputPreco.getLength() > 0 && inputQntd.getLength() > 0) {
            boolean precoValidado = validarPreco();
            boolean qntdValidada = validarQntd();
            if (precoValidado && qntdValidada) {
                int qntd = Integer.parseInt(inputQntd.getText());
                double preco = Double.parseDouble(inputPreco.getText());

                alterarProduto(qntd, preco);
            } else {
                erro = true;
            }
        } else if (inputPreco.getLength() > 0) {
            boolean precoValidado = validarPreco();
            if (precoValidado) {
                int qntd = ultimoProdutoPesquisado.getQuantidade();
                double preco = Double.parseDouble(inputPreco.getText());
                alterarProduto(qntd, preco);
            } else {
                erro = true;
              }
        } else {
            boolean qntdValidada = validarQntd();
            if (qntdValidada){
                int qntd = Integer.parseInt(inputQntd.getText());
                double preco = ultimoProdutoPesquisado.getPreco();
                alterarProduto(qntd, preco);
            } else {
                erro = true;
            }
        }

        if (erro){
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Um ou mais campos inseridos incorretamente!");
            spam.show();
        }
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane alterar;
        try {
            alterar = FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
            painelAlterarProdutos.getChildren().setAll(alterar);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    private boolean validarQntd(){
        try{
            int quantidade = Integer.parseInt(inputQntd.getText());

            return true;
        } catch (Exception e){
            inputQntd.setText("");
            return false;
        }

    }

    private boolean validarPreco(){
        String preco = inputPreco.getText();

        try{
            if (preco.contains(",")){
                inputPreco.setText(preco.replace(",", "."));
                Double.parseDouble(inputPreco.getText());
            } else{
                Double.parseDouble(preco);
            }
            return true;
        } catch (Exception e){
            inputPreco.setText("");
            return false;
        }

    }
    private void alterarProduto(int qntd, double preco) {
        String id = ultimoProdutoPesquisado.getId();

        try {
            ProjetoPoo.petShop.atualizarProduto(id, qntd, preco);
        } catch (QuantidadeInvalidaException | ProdutoInexistenteException e) {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText(e.getMessage());
            spam.show();
        }

        spam.setAlertType(Alert.AlertType.INFORMATION);
        spam.setContentText("Produto alterado com sucesso!");
        spam.show();

        tbView.getItems().clear();
        inputQntd.setText("");
        inputPreco.setText("");
        tbView.getItems().add(ultimoProdutoPesquisado);
    }
}
