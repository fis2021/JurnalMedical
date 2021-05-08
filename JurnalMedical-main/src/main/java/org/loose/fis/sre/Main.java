package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.MedicService;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.services.PacientService;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {
    public static Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stg=primaryStage;
        initDirectory();
        UserService.initDatabase();
        PacientService.initDatabase();
        MedicService.initDatabase1();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("initialpage.fxml"));
        primaryStage.setTitle("Jurnal medical");
<<<<<<< HEAD
        primaryStage.setScene(new Scene(root, 890, 375));
=======
        primaryStage.setScene(new Scene(root));
>>>>>>> b42c8ba474ed51ea5e7b39f503a9d7df6ce26948
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
