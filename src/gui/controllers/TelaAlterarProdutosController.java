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
    @FXML
    private Pane painelAlterarProdutos;
    @FXML
    private TextField inputId;
    @FXML
    private Button btnBuscar;
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
        tbNome.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbMarca.setCellValueFactory(
                new PropertyValueFactory<>("Marca"));
        tbQntd.setCellValueFactory(
                new PropertyValueFactory<>("Quantidade"));
        tbPreco.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));

        //TEste
        try {
            ProjetoPoo.petShop.cadastrarProduto("Jhonson", "JJ Jhonso", 12.5, "p1", 50);
        } catch (ProdutoJaCadastradoException e) {
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
                ultimoProdutoPesquisado = ProjetoPoo.petShop.consultarProduto(inputId.getText());

                tbView.getItems().clear();
                tbView.getItems().add(ultimoProdutoPesquisado); // Insere produto na Tabela de visualizacao
                btnRemoverProduto.setDisable(false);
                btnConfirmar.setDisable(false);
            } catch (ProdutoInexistenteException e){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
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

        ProjetoPoo.petShop.removerProduto(ultimoProdutoPesquisado.getId());

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("Produto removido com sucesso!");
        a.show();

        inputId.setText("");
        btnRemoverProduto.setDisable(true);
        btnConfirmar.setDisable(true);
    }

    @FXML
    private void qntdInputHandler(ActionEvent event) {
    }

    @FXML
    private void precoInputHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) throws ProdutoInexistenteException {
        boolean erro = false;

        if (inputPreco.getLength()==0 && inputQntd.getLength()==0){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Insira pelo menos uma alteração");
            a.show();
        } else if (inputPreco.getLength()>0 && inputQntd.getLength()>0){
            boolean precoValidado = validarPreco();
            boolean qntdValidada = validarQntd();
            if (precoValidado && qntdValidada){
                try{
                    alterarProduto();
                } catch (QuantidadeInvalidaException e) {
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText(e.getMessage());
                    a.show();
                    inputQntd.setText("");
                }
            } else {
                erro = true;
            }
        } else if (inputPreco.getLength()>0){
            boolean precoValidado = validarPreco();
            if (precoValidado){
                try{
                    alterarProduto();
                } catch (QuantidadeInvalidaException e) {
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText(e.getMessage());
                    a.show();
                    inputQntd.setText("");
                }
            } else {
                erro = true;
            }
        } else {
            boolean qntdValidada = validarQntd();
            if (qntdValidada){
                try{
                    alterarProduto();
                } catch (QuantidadeInvalidaException e){
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText(e.getMessage());
                    a.show();
                    inputQntd.setText("");
                }
            } else {
                erro = true;
            }
        }

        if (erro){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Um ou mais campos inseridos incorretamente!");
            a.show();
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
    private void alterarProduto() throws ProdutoInexistenteException, QuantidadeInvalidaException {
        String id = ultimoProdutoPesquisado.getId();

        if(inputQntd.getLength()>0 && inputPreco.getLength()>0){
            int qntd = Integer.parseInt(inputQntd.getText());
            double preco = Double.parseDouble(inputPreco.getText());
            ProjetoPoo.petShop.atualizarProduto(id, qntd, preco);
        }
        else if(inputQntd.getLength()>0 && inputPreco.getLength()==0){
            int qntd = Integer.parseInt(inputQntd.getText());
            ProjetoPoo.petShop.atualizarProduto(id, qntd, ultimoProdutoPesquisado.getPreco());
        }
        else if(inputQntd.getLength()==0 && inputPreco.getLength()>0){
            double preco = Double.parseDouble(inputPreco.getText());
            ProjetoPoo.petShop.atualizarProduto(id, ultimoProdutoPesquisado.getQuantidade(), preco);
        }

        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("Produto alterado com sucesso!");
        a.show();

        tbView.getItems().clear();
        inputQntd.setText("");
        inputPreco.setText("");
        tbView.getItems().add(ultimoProdutoPesquisado);
    }
}
