package gui.controllers;

import gui.ProjetoPoo;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import negocio.contratos.ServicoAbstrato;
import negocio.entidades.Cliente;
import negocio.excecoes.ClienteInexistenteException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TelaAlterarServicoController implements Initializable {
    private Alert spam;

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
    public TableView<ServicoAbstrato> tbServicoview;
    @FXML
    public TableColumn<ServicoAbstrato, String> tbServico;
    @FXML
    public TableColumn<ServicoAbstrato, String> tbNome;
    @FXML
    public TableColumn<ServicoAbstrato, String> tbData;
    @FXML
    public TableColumn<ServicoAbstrato, String> tbHora;
    @FXML
    public Button btnCancelar;
    @FXML
    public Button btnMarcarConcluido;

    public TelaAlterarServicoController(){
        spam = new Alert(Alert.AlertType.NONE);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbNome.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getNome()));
        tbServico.setCellValueFactory(
                new PropertyValueFactory<>("Descricao"));
        tbData.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        tbHora.setCellValueFactory(
                new PropertyValueFactory<>("horaAgendada"));
    }

    @FXML
    public void marcarConcluidoBtnHandler(ActionEvent actionEvent) {
        ServicoAbstrato servico = tbServicoview.getSelectionModel().getSelectedItem();
        if (servico!=null){
            tbServicoview.getItems().remove(servico);

            ProjetoPoo.petShop.marcarServicoConcluido(servico);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Serviço concluído com sucesso!");
            spam.show();
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um serviço!");
            spam.show();
        }

    }

    @FXML
    public void cancelarBtnHandler(ActionEvent actionEvent) {
        Pane alterar;
        try {
            alterar = FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
            painelAlterarServico.getChildren().setAll(alterar);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    public void buscarBtnHandler(ActionEvent actionEvent) {
        tbServicoview.getItems().clear();

        if (inputCpf.getLength()>0){
            try{
                Cliente cliente = ProjetoPoo.petShop.consultarCliente(inputCpf.getText());
                ArrayList<ServicoAbstrato> servicosNaoConcluidos = ProjetoPoo.petShop.consultarServicosClienteNaoConcluidos(
                        cliente.getCpf());

                for (ServicoAbstrato s: servicosNaoConcluidos){
                    tbServicoview.getItems().add(s);
                }

                if (servicosNaoConcluidos.isEmpty()){
                    spam.setAlertType(Alert.AlertType.INFORMATION);
                    spam.setContentText("Nenhum serviço não conluído encontrado!");
                    spam.show();
                }
            } catch (ClienteInexistenteException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();
            }
        }
    }

    @FXML
    public void removerServicoBtnHandler(ActionEvent actionEvent) {
        ServicoAbstrato servico = tbServicoview.getSelectionModel().getSelectedItem();
        if (servico!=null){
            tbServicoview.getItems().remove(servico);

            ProjetoPoo.petShop.desmarcarServico(servico);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Serviço removido com sucesso!");
            spam.show();
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um pet!");
            spam.show();
        }
    }

    public void alterarBtnHandler(ActionEvent actionEvent) {
    }

}
