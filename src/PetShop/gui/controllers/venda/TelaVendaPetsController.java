/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.venda;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import PetShop.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.PetPetshop;
import PetShop.negocio.excecoes.PetPetshopInexistenteException;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaVendaPetsController implements Initializable {

    @FXML
    private TableView<PetPetshop> tbView;
    @FXML
    private TextField inputId;
    @FXML
    private TableColumn<PetPetshop, String> tbEspecie;
    @FXML
    private TableColumn<PetPetshop, String> tbSexo;
    @FXML
    private TableColumn<PetPetshop, String> tbDataDeNascimento;
    @FXML
    private TableColumn<PetPetshop, String> tbPeso;
    @FXML
    private TableColumn<PetPetshop, String> tbTamanho;
    @FXML
    private TableColumn<PetPetshop, Double> tbPreco;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Pane painelVendaPets;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        tbDataDeNascimento.setCellValueFactory(
                new PropertyValueFactory<>("DataNascimento"));
        tbPeso.setCellValueFactory(
                new PropertyValueFactory<>("Peso"));
        tbSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));
        tbTamanho.setCellValueFactory(
                new PropertyValueFactory<>("Tamanho"));
        tbPreco.setCellValueFactory(
                new PropertyValueFactory<>("Preco"));

    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
        try{
            Main.petShop.venderPetPetshop(inputId.getText());

            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Pet vendido com sucesso!");
            a.show();

            btnConfirmar.setDisable(true);
            tbView.setItems(null);

        } catch (PetPetshopInexistenteException e){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText(e.getMessage());
            a.show();
        }
        inputId.setText("");
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane venda;
        try {
            venda = FXMLLoader.load(getClass().getResource("../../views/venda/TelaVenda.fxml"));
            painelVendaPets.getChildren().setAll(venda);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputId.getText().length() > 0){
            try{
                PetPetshop pet = Main.petShop.consultarPetPetshop(inputId.getText());

                preencherTabela(pet);
            } catch (PetPetshopInexistenteException e){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText(e.getMessage());
                a.show();

                tbView.setItems(null);
                btnConfirmar.setDisable(true);
            }


        } else {
            tbView.setItems(null);
        }
    }

    private void preencherTabela(PetPetshop pet) {
        tbView.setItems(petInfo(pet));

        btnConfirmar.setDisable(false);
    }

    private ObservableList<PetPetshop> petInfo(PetPetshop pet) {
        return FXCollections.observableArrayList(pet);
    }

}
