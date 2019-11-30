package PetShop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import PetShop.negocio.PetShopFachada;

/**
 * Classe Main. Herda de application e starta o sistema
 *
 * @author Tárcio Lins, Manoel Gustavo, Letícia Araújo, Fábio dos Santos
 */
public class Main extends Application {
    public static PetShopFachada petShop;
    public static Stage stageMain;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/views/MenuInicial.fxml"));
        stageMain = stage;
        Scene scene = new Scene(root);

        stageMain.setScene(scene);
        stageMain.show();
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        petShop = new PetShopFachada();
        launch(args);
    }
    
}
