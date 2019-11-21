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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.entidades.Produto;
import negocio.exececoes.ProdutoInexistenteException;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaVendaProdutosController implements Initializable {

    @FXML
    private Pane painelVendaProdutos;
    @FXML
    private TextField inputId;
    @FXML
    private TextField inputqtd;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnAdicionarAoCarrinho;
    @FXML
    private TableView<Produto> tbViewCarrinho;
    @FXML
    private TableColumn<?, ?> tbProdutoCarrinho;
    @FXML
    private TableColumn<?, ?> tbMarcaCarrinho;
    @FXML
    private TableColumn<?, ?> tbQtdCarrinho;
    @FXML
    private TableColumn<?, ?> tbPrecoCarrinho;
    @FXML
    private TableView<Produto> tbView;
    @FXML
    private TableColumn<?, ?> tbProduto;
    @FXML
    private TableColumn<?, ?> tbMarca;
    @FXML
    private TableColumn<?, ?> tbQtd;
    @FXML
    private TableColumn<?, ?> tbPreco;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProjetoPoo.petShop.cadastrarProduto("Jhonsons Shampoo", "JJ Jhonsons", 12.50, "P01", 20);
    }

    @FXML
    private void idInputHandler(ActionEvent event) {
    }

    @FXML
    private void qtdInputHandler(ActionEvent event) {
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputId.getText().length() > 0){
            try{
                Produto produto = ProjetoPoo.petShop.consultarProduto(inputId.getText());

                btnAdicionarAoCarrinho.setDisable(false);
            } catch (ProdutoInexistenteException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                inputId.setText("");
            }

        }

//            tbProduto.setCellValueFactory(
//                    new PropertyValueFactory<>("Nome"));
//            tbMarca.setCellValueFactory(
//                    new PropertyValueFactory<>("Marca"));
//            tbQtd.setCellValueFactory(
//                    new PropertyValueFactory<>("Quantidade"));
//            tbPreco.setCellValueFactory(
//                    new PropertyValueFactory<>("Preco"));
//
//
//            tbView.setItems(pInfo());
    }
    private ObservableList<Produto> pInfo() {
        // Classe pet apenas para teste
        Produto p = new Produto("Jhonsons Shampoo", "JJhonsons", 12.5, "P25", 15);
        Produto a = new Produto("Jhonsons Shampoo", "JJhonsons", 12.5, "P25", 15);
        Produto d = new Produto("Jhonsons Shampoo", "JJhonsons", 12.5, "P25", 15);
        Produto as = new Produto("Jhonsons Shampoo", "JJhonsons", 12.5, "P25", 15);
        Produto s = new Produto("Jhonsons Shampoo", "JJhonsons", 12.5, "P25", 15);
        Produto o = new Produto("Jhonsons Shampoo", "JJhonsons", 12.5, "P25", 15);

        return FXCollections.observableArrayList(p, a, d, as, s, o, p, p,p, p);
    }

    @FXML
    private void adicionarCarrinhoBtnHandler(ActionEvent event) {
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane venda;
        try {
            venda = FXMLLoader.load(getClass().getResource("../views/TelaVenda.fxml"));
            painelVendaProdutos.getChildren().setAll(venda);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

}
