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

import PetShop.Main;
import PetShop.gui.controllers.MenuInicialController;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.VendaPet;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaListarVendaPetsController implements Initializable {
    @FXML
    private Pane painelHistoricoPets;
    @FXML
    private DatePicker dateSalePets;
    @FXML
    private TableView<VendaPet> tbView;
    @FXML
    private TableColumn<VendaPet, String> tbId;
    @FXML
    private TableColumn<VendaPet, String> tbEspecie;
    @FXML
    private TableColumn<VendaPet, String> tbSexo;
    @FXML
    private TableColumn<VendaPet, String> tbDataDeNasc;
    @FXML
    private TableColumn<VendaPet, String> tbPeso;
    @FXML
    private TableColumn<VendaPet, String> tbTam;
    @FXML
    private TableColumn<VendaPet, String> tbPreco;
    @FXML
    private TableColumn<VendaPet, String> tbHora;
    @FXML
    private TableColumn<?, ?> tbDataVenda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbId.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getId()));
        tbEspecie.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getEspecie()));
        tbDataDeNasc.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getDataNascimento()));
        tbPeso.setCellValueFactory(pet -> new SimpleStringProperty(String.valueOf(pet.getValue().getPet().getPeso())));
        tbSexo.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getSexo()));
        tbTam.setCellValueFactory(pet -> new SimpleStringProperty(String.valueOf(pet.getValue().getPet().getTamanho())));
        tbPreco.setCellValueFactory(pet -> new SimpleStringProperty(String.valueOf(pet.getValue().getPet().getPreco())));
        tbDataVenda.setCellValueFactory(
                new PropertyValueFactory<>("data"));
        tbHora.setCellValueFactory(
                new PropertyValueFactory<>("hora"));

        preencherHistorico();
    }

    private void preencherHistorico(){
        ArrayList<VendaPet> vendas = Main.petShop.consultarVendasPet();
        for (VendaPet v: vendas) {
            tbView.getItems().add(v);
        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        LocalDate date = dateSalePets.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        tbView.getItems().clear();
        if (dateSalePets.getValue()!=null){
            String data = date.format(formatter);
            ArrayList<VendaPet> vendaPets = Main.petShop.consultarVendasPetPorData(data);

            for (VendaPet v: vendaPets) {
                tbView.getItems().add(v);
            }
        } else {
            preencherHistorico();
        }

    }

    @FXML
    private void voltarBtnHandler(ActionEvent event) {
        Pane historicoPets;
        try {
            historicoPets = FXMLLoader.load(getClass().getResource("../../views/consultas/TelaListar.fxml"));
            painelHistoricoPets.getChildren().setAll(historicoPets);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


