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
import negocio.exececoes.ProdutoInexistenteException;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaVendaProdutosController implements Initializable {
    private double valorT;
    private Produto ultimoProdutoPesquisado;

    @FXML
    private Pane painelVendaProdutos;
    @FXML
    private TextField inputId;
    @FXML
    private Label lblValorTotal;
    @FXML
    private TextField inputqtd;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnVender;
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
    private Button btnVoltar;


    /**
     * Initializes the controller class.
     */

    public TelaVendaProdutosController(){
        this.valorT = 0.0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProjetoPoo.petShop.cadastrarProduto("Jhonsons Shampoo", "JJ Jhonsons", 12.50, "P01",
                20);

        ProjetoPoo.petShop.cadastrarProduto("Racao Dog Rancho", "Du Rancho", 50.50, "P02",
                10);


        tbProduto.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbMarca.setCellValueFactory(
                new PropertyValueFactory<>("Marca"));
        tbQtd.setCellValueFactory(
                new PropertyValueFactory<>("Quantidade"));
        tbPreco.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));

        tbProdutoCarrinho.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        tbMarcaCarrinho.setCellValueFactory(
                new PropertyValueFactory<>("Marca"));
        tbQtdCarrinho.setCellValueFactory(
                new PropertyValueFactory<>("Quantidade"));
        tbPrecoCarrinho.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));
    }
    @FXML
    private void idInputHandler(ActionEvent event) {
    }

    @FXML
    private void qtdInputHandler(ActionEvent event) {
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        tbView.getItems().removeAll(ultimoProdutoPesquisado);
        if (inputId.getText().length() > 0){
            try{
                ultimoProdutoPesquisado = ProjetoPoo.petShop.consultarProduto(inputId.getText());
                tbView.getItems().add(ultimoProdutoPesquisado); // Insere produto na Tabela de visualizacao
                btnVender.setDisable(false);
            } catch (ProdutoInexistenteException e){
                JOptionPane.showMessageDialog(null,e.getMessage());

                btnVender.setDisable(true);
            }
        }
    }

    @FXML
    private void btnVenderHandler(ActionEvent event) {
        int qnt = Integer.parseInt(inputqtd.getText());
        // Quuantiidade inválida throw, pode ser texto, metodo(validaQtd)

        this.valorT += ultimoProdutoPesquisado.getPreco() * qnt;
        ultimoProdutoPesquisado.decrementarQntd(qnt);

        lblValorTotal.setText(String.format("Valor Total R$ %.2f", this.valorT));
        tbView.getItems().removeAll(ultimoProdutoPesquisado);

        tbViewCarrinho.getItems().add((new Produto(ultimoProdutoPesquisado.getNome(), ultimoProdutoPesquisado.getMarca(),
                ultimoProdutoPesquisado.getPreco()*qnt, ultimoProdutoPesquisado.getId(), qnt)));

        btnVender.setDisable(true);
        inputId.setText("");
        inputqtd.setText("1");
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane venda;
        try {
            if (valorT>0){
                JOptionPane.showMessageDialog(null, "Venda no valor total de R$"+valorT + " efetuada!");
            }
            venda = FXMLLoader.load(getClass().getResource("../views/TelaVenda.fxml"));
            painelVendaProdutos.getChildren().setAll(venda);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

}
