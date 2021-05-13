package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.Main;

public class InitialPageController {
    public static Stage stg;
    @FXML
    public void handleLoginButtonAction() throws Exception{
        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("Login.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            this.stg=stage;
            Main.stg.close();
        }catch(Exception e){e.printStackTrace();}

    }

    @FXML
    public void handleRegisterButtonAction() throws Exception{
        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){e.printStackTrace();}


    }
}

