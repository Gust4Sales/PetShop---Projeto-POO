package PetShop.gui.controllers.alterar;

import PetShop.ProjetoPoo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import PetShop.negocio.contratos.ServicoAbstrato;
import PetShop.negocio.entidades.Cliente;
import PetShop.negocio.excecoes.ClienteInexistenteException;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class TelaAlterarServicoController implements Initializable {
    private Alert spam;

    @FXML
    public Pane painelAlterarServico;
    @FXML
    public DatePicker dataAlterar;
    @FXML
    public ChoiceBox<String> choiceHorario;
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
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = sdfData.format(new Date());

        LocalDate minDate = LocalDate.now();

        dataAlterar.setDayCellFactory(d ->
                new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isBefore(minDate));
                    }});

        tbNome.setCellValueFactory(pet -> new SimpleStringProperty(pet.getValue().getPet().getNome()));
        tbServico.setCellValueFactory(
                new PropertyValueFactory<>("Descricao"));
        tbData.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        tbHora.setCellValueFactory(
                new PropertyValueFactory<>("horaAgendada"));

        dataAlterar.setValue(minDate);
        preencherListaHoras(dataAtual);
    }

    private void preencherListaHoras(String data){
        ArrayList<String> lista = ProjetoPoo.petShop.consultarListaHorariosLivres(data);

        ObservableList<String> choicesList = FXCollections.observableArrayList(lista);
        choiceHorario.setItems(choicesList);
    }

    @FXML
    private void marcarConcluidoBtnHandler(ActionEvent actionEvent) {
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
    private void cancelarBtnHandler(ActionEvent actionEvent) {
        Pane alterar;
        try {
            alterar = FXMLLoader.load(getClass().getResource("../../views/alterar/TelaAlterar.fxml"));
            painelAlterarServico.getChildren().setAll(alterar);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void buscarBtnHandler(ActionEvent actionEvent) {
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
                } else {
                    btnAlterar.setDisable(false);
                }
            } catch (ClienteInexistenteException e) {
                spam.setAlertType(Alert.AlertType.ERROR);
                spam.setContentText(e.getMessage());
                spam.show();
            }
        } else {
            btnAlterar.setDisable(true);
        }
    }

    @FXML
    private void removerServicoBtnHandler(ActionEvent actionEvent) {
        ServicoAbstrato servico = tbServicoview.getSelectionModel().getSelectedItem();
        if (servico!=null){
            tbServicoview.getItems().remove(servico);

            ProjetoPoo.petShop.desmarcarServico(servico);

            spam.setAlertType(Alert.AlertType.INFORMATION);
            spam.setContentText("Serviço removido com sucesso!");
            spam.show();
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um um serviço!");
            spam.show();
        }
    }

    @FXML
    private void alterarBtnHandler(ActionEvent actionEvent) {
        ServicoAbstrato servico = tbServicoview.getSelectionModel().getSelectedItem();
        if (choiceHorario.getValue()!=null && servico!=null){
            String data = dataAlterar.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            ProjetoPoo.petShop.alterarServico(servico, data, choiceHorario.getValue());
            tbServicoview.getItems().clear();
            tbServicoview.getItems().add(servico);
        } else {
            spam.setAlertType(Alert.AlertType.ERROR);
            spam.setContentText("Selecione um horário e um serviço!");
            spam.show();
        }
    }
    @FXML
    private void changeDataHandler(ActionEvent actionEvent){
        if (dataAlterar.getValue()!=null){
            String data = dataAlterar.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            preencherListaHoras(data);
        }
    }

}
