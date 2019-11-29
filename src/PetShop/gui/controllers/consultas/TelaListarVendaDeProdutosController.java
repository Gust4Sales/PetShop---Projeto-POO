/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.consultas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import PetShop.ProjetoPoo;
import PetShop.gui.controllers.MenuInicialController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.VendaProduto;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class TelaListarVendaDeProdutosController implements Initializable {

    @FXML
    private Pane painelHistoricoVendas;
    @FXML
    private TableView<VendaProduto> tbView;
    @FXML
    private TableColumn<VendaProduto, String> tbId;
    @FXML
    private TableColumn<VendaProduto, String> tbNome;
    @FXML
    private TableColumn<VendaProduto, String> tbMarca;
    @FXML
    private TableColumn<VendaProduto, String> tbQuantidade;
    @FXML
    private TableColumn<VendaProduto, String> tbPreco;
    @FXML
    private TableColumn<VendaProduto, String> tbDataDeVenda;
    @FXML
    private TableColumn<VendaProduto, String> tbHora;
    @FXML
    private DatePicker dateBuscarHistorico;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LocalDate maxDate = LocalDate.now();
        dateBuscarHistorico.setDayCellFactory(d ->
                new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isAfter(maxDate));
                    }});

        tbId.setCellValueFactory(prod -> new SimpleStringProperty(prod.getValue().getProduto().getId()));
        tbMarca.setCellValueFactory(prod -> new SimpleStringProperty(prod.getValue().getProduto().getMarca()));
        tbNome.setCellValueFactory(prod -> new SimpleStringProperty(prod.getValue().getProduto().getNome()));
        tbQuantidade.setCellValueFactory(prod -> new SimpleStringProperty(String.valueOf(
                prod.getValue().getProduto().getQuantidade())));
        tbDataDeVenda.setCellValueFactory(new PropertyValueFactory<>("data"));
        tbHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        tbPreco.setCellValueFactory(prod -> new SimpleStringProperty(String.valueOf(
                prod.getValue().getProduto().getPreco())));

        preencherHistorico();

    }


    private void preencherHistorico(){
        ArrayList<VendaProduto> vendas = ProjetoPoo.petShop.consultarVendaProdutos();
        for (VendaProduto v: vendas) {
            tbView.getItems().add(v);
        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        LocalDate date = dateBuscarHistorico.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        tbView.getItems().clear();
        if (dateBuscarHistorico.getValue()!=null){
            String data = date.format(formatter);
            ArrayList<VendaProduto> vendaProdutos = ProjetoPoo.petShop.consultarVendaProdutosPorData(data);

            for (VendaProduto v: vendaProdutos) {
                tbView.getItems().add(v);
            }
        } else {
            preencherHistorico();
        }
    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane historicoVendas;
        try {
            historicoVendas = FXMLLoader.load(getClass().getResource("../../views/consultas/TelaListar.fxml"));
            painelHistoricoVendas.getChildren().setAll(historicoVendas);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
}


