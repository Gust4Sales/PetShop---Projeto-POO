/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.venda;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import PetShop.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.Produto;
import PetShop.negocio.excecoes.ProdutoInexistenteException;
import PetShop.negocio.excecoes.QuantidadeInvalidaException;

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



    /**
     * Initializes the controller class.
     */

    public TelaVendaProdutosController(){
        this.valorT = 0.0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void buscarBtnHandler(ActionEvent event) {
        tbView.getItems().removeAll(ultimoProdutoPesquisado);
        if (inputId.getText().length() > 0){
            try{
                ultimoProdutoPesquisado = ProjetoPoo.petShop.consultarProduto(inputId.getText());
                tbView.getItems().add(ultimoProdutoPesquisado); // Insere produto na Tabela de visualizacao
                btnVender.setDisable(false);
            } catch (ProdutoInexistenteException e){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
                btnVender.setDisable(true);
            }
        }
    }

    @FXML
    private void btnVenderHandler(ActionEvent event) {
        boolean validado = validarQntd(inputqtd.getText());

        if (validado) {
            int qnt = Integer.parseInt(inputqtd.getText());
            try {
                ProjetoPoo.petShop.venderProduto(inputId.getText(), qnt);

                this.valorT += ultimoProdutoPesquisado.getPreco() * qnt;
            } catch (QuantidadeInvalidaException | ProdutoInexistenteException e) {
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();
                return;
            }

            lblValorTotal.setText(String.format("Valor Total R$ %.2f", this.valorT));
            tbView.getItems().removeAll(ultimoProdutoPesquisado);

            tbViewCarrinho.getItems().add((new Produto(ultimoProdutoPesquisado.getNome(), ultimoProdutoPesquisado.getMarca(),
                    ultimoProdutoPesquisado.getPreco() * qnt, ultimoProdutoPesquisado.getId(), qnt)));

            btnVender.setDisable(true);
            inputId.setText("");
            inputqtd.setText("1");
        }
    }

    private boolean validarQntd(String qntd){
        try {
            int qtd = Integer.parseInt(qntd);
            if (qtd<=0){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Quantidade inválida");
                a.show();

                inputqtd.setText("1");
                return false;
            }
            return true;
        } catch (Exception e){
            inputqtd.setText("");
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Quantidade inválida");
            return false;
        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane venda;
        try {
            if (valorT>0){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Venda no valor total de R$"+valorT + " efetuada");
                a.show();

            }
            venda = FXMLLoader.load(getClass().getResource("../../views/venda/TelaVenda.fxml"));
            painelVendaProdutos.getChildren().setAll(venda);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
