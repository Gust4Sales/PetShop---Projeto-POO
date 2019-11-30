/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.consultas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import PetShop.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.Produto;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaListarProdutosController implements Initializable {
    @FXML
    private Pane painelEstoqueProdutos;
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

        ArrayList<Produto> produtos = Main.petShop.consultarProdutosEstoque();

        for (Produto produto: produtos){
            tbView.getItems().add(produto);
        }

    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane listar;
        try {
            listar = FXMLLoader.load(getClass().getResource("../../views/consultas/TelaListar.fxml"));
            painelEstoqueProdutos.getChildren().setAll(listar);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
