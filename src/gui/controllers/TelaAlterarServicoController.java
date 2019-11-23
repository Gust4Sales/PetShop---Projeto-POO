package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TelaAlterarServicoController {
    @FXML
    public Pane painelAlterarServico;
    @FXML
    public DatePicker dataAlterar;
    @FXML
    public ChoiceBox choiceHorario;
    @FXML
    public ListView listaAlterar;
    @FXML
    public Button btnAlterar;
    @FXML
    public Button btnRemoverServico;
    @FXML
    public TextField inputCpf;
    @FXML
    public Button btnBuscar;
    @FXML
    public TableView tbServicoview;
    @FXML
    public TableColumn tbServico;
    @FXML
    public TableColumn tbData;
    @FXML
    public TableColumn tbHora;
    @FXML
    public Button btnCancelar;
    @FXML
    public Button btnMarcarConcluido;

    public void MarcarConcluidoBtnHandler(ActionEvent actionEvent) {
    }

    public void cancelarBtnHandler(ActionEvent actionEvent) {
        Pane alterar;
        try {
            alterar = FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
            painelAlterarServico.getChildren().setAll(alterar);

        } catch (IOException ex) {
            System.out.println(ex);

        }
    }

    public void buscarBtnHandler(ActionEvent actionEvent) {
    }

    public void removerServicoBtnHandler(ActionEvent actionEvent) {
    }

    public void alterarBtnHandler(ActionEvent actionEvent) {
    }
}
