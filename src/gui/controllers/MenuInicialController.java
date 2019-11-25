package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.ProjetoPoo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import negocio.contratos.ServicoAbstrato;
import negocio.entidades.Cliente;
import negocio.entidades.PetCliente;
import negocio.entidades.ServicoBanho;
import negocio.entidades.ServicoCompleto;

/**
 * FXML Controller class
 *
 * @author tarci
 */
public class MenuInicialController implements Initializable {

    @FXML
    private Button btnVenda;
    @FXML
    private Button btnAgenda;
    @FXML
    private Pane painel;
    @FXML
    private Button btnCadastro;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnListar;
    @FXML
    private Button btnSair;

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
            telaVenda = FXMLLoader.load(getClass().getResource("../views/TelaVenda.fxml"));
            painel.getChildren().setAll(telaVenda);
           
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }

    @FXML
    private void agendaBtnHandler(ActionEvent event) {
         Pane telaAgendamento;
        try {
            telaAgendamento = FXMLLoader.load(getClass().getResource("../views/TelaAgendamento.fxml"));
            painel.getChildren().setAll(telaAgendamento);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cadastroBtnHandler(ActionEvent event) {
        Pane telaCadastro;
        try {
            telaCadastro = FXMLLoader.load(getClass().getResource("../views/TelaCadastro.fxml"));
            painel.getChildren().setAll(telaCadastro);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void alterarBtnHandler(ActionEvent event) {
        Pane telaAlterar;
        try {
            telaAlterar = FXMLLoader.load(getClass().getResource("../views/TelaAlterar.fxml"));
            painel.getChildren().setAll(telaAlterar);
           
        } catch (IOException ex) {
            Logger.getLogger(MenuInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listarBtnHandler(ActionEvent event) {
        Pane telaListar;
        try {
            telaListar = FXMLLoader.load(getClass().getResource("../views/TelaListar.fxml"));
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
