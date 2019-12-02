package PetShop.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 * Essa classe faz a conexão entre a interface gráfica e a fachada.
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class MenuInicialController implements Initializable {

    @FXML
    private Pane painel;
    /**
     * Initializes the controller class.
     */
    public MenuInicialController(){

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vendaBtnHandler(ActionEvent event) {
        Pane telaVenda;
        try {
            telaVenda = FXMLLoader.load(getClass().getResource("../views/venda/TelaVenda.fxml"));
            painel.getChildren().setAll(telaVenda);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void agendaBtnHandler(ActionEvent event) {
         Pane telaAgendamento;
        try {
            telaAgendamento = FXMLLoader.load(getClass().getResource("../views/agendamento/TelaAgendamento.fxml"));
            painel.getChildren().setAll(telaAgendamento);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cadastroBtnHandler(ActionEvent event) {
        Pane telaCadastro;
        try {
            telaCadastro = FXMLLoader.load(getClass().getResource("../views/cadastro/TelaCadastro.fxml"));
            painel.getChildren().setAll(telaCadastro);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void alterarBtnHandler(ActionEvent event) {
        Pane telaAlterar;
        try {
            telaAlterar = FXMLLoader.load(getClass().getResource("../views/alterar/TelaAlterar.fxml"));
            painel.getChildren().setAll(telaAlterar);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listarBtnHandler(ActionEvent event) {
        Pane telaListar;
        try {
            telaListar = FXMLLoader.load(getClass().getResource("../views/consultas/TelaListar.fxml"));
            painel.getChildren().setAll(telaListar);

        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sairBtnHandler(ActionEvent event) {
        System.exit(0);
    }
    
}
