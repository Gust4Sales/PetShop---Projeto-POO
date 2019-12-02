/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetShop.gui.controllers.agendamento;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import PetShop.Main;
import PetShop.gui.controllers.MenuInicialController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.entidades.PetCliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class TelaServicoController implements Initializable {
    private Alert spam;
    private String hora;
    private String data;
    private Cliente cliente;

    @FXML
    private Pane painelServico;
    @FXML
    private TextField inputBuscarCpf;
    @FXML
    private TableView<PetCliente> tbView;
    @FXML
    private TableColumn<?, ?> nomePet;
    @FXML
    private TableColumn<?, ?> nomeSexo;
    @FXML
    private TableColumn<?, ?> nomeEspecie;
    @FXML
    private ChoiceBox<String> choiceServico;
    @FXML
    private Label lblAgenda;
    @FXML
    private Label lblValor;

    public TelaServicoController(){
        spam = new Alert(Alert.AlertType.NONE);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomePet.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        nomeEspecie.setCellValueFactory(
                new PropertyValueFactory<>("Especie"));
        nomeSexo.setCellValueFactory(
                new PropertyValueFactory<>("Sexo"));

        ObservableList<String> choicesList = FXCollections.observableArrayList("Banho", "Tosa", "Completo");

        choiceServico.setValue(null);
        choiceServico.setItems(choicesList);

        choiceServico.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String servicoEscolhido = (choicesList.get(newValue.intValue()));
                if (servicoEscolhido.equals("Banho") || servicoEscolhido.equals("Tosa")){
                    lblValor.setText("Valor R$" + "25,00");
                } else {
                    lblValor.setText("Valor R$" + "45,00");
                }
            }
        });
    }

    @FXML
    private void buscarBtnHandler(ActionEvent event) {
        if (inputBuscarCpf.getLength()>0){
            tbView.getItems().clear();
            try{
                cliente = Main.petShop.consultarCliente(inputBuscarCpf.getText());
                for (PetCliente pet: cliente.getPets()){
                    tbView.getItems().add(pet);
                }
            } catch (ClienteInexistenteException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();

                tbView.getItems().clear();
            }
        } else {
            tbView.getItems().clear();
        }
    }

    @FXML
    private void confirmarBtnHandler(ActionEvent event) {
        PetCliente pet = tbView.getSelectionModel().getSelectedItem();
        String descricao = choiceServico.getValue();

        if ((choiceServico.getValue()!=null) && (pet!=null)){
            Main.petShop.agendarServico(descricao, hora, data, cliente, pet);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Agendamento marcado! "+"Serviço "+descricao+" no Pet "+ pet.getNome() + " agendado às "+hora+"h do dia "+data);
            spam.show();
            cancelarBtnHandler(event);
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um serviço e um pet");
            spam.show();
        }
    }

    @FXML
    private void cancelarBtnHandler(ActionEvent event) {
        Pane menuInicial;
        try {
            menuInicial = FXMLLoader.load(getClass().getResource("../../views/agendamento/TelaAgendamento.fxml"));
            painelServico.getChildren().setAll(menuInicial);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void transferirInfo(String dataAgendada, String horaAgendada){
        hora = horaAgendada;
        data = dataAgendada;

        lblAgenda.setText("Agendamento pro dia "+data+" às "+hora+"h");

    }
}
