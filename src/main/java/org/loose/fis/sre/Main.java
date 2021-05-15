package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.MedicService;
import org.loose.fis.sre.services.PacientService;
import org.loose.fis.sre.services.UserService;

public class Main extends Application {
    public static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.stg=primaryStage;

        UserService.initDatabase();
        PacientService.initDatabase();
        MedicService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("initialpage.fxml"));
        primaryStage.setTitle("Jurnal medical");

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}
