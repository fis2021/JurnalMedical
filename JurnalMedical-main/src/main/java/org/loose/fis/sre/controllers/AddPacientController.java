package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.services.MedicService;


public class AddPacientController {
    @FXML
    public TextField pacientField;
    @FXML
    public static Stage stg;
    public void handleAddPacientButtonAction() throws Exception{
        MedicService.addPacient2(LoginController.medic,pacientField.getText());
        try {if(stg!=null)stg.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Medic.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            MedicController d=fxmlLoader.<MedicController>getController();
            d.EmptyJournal(LoginController.medic);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            this.stg=stage;
            LoginController.stg.close();
            MedicController.stg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleCancelMButtonAction(){
        MedicController.stg.close();
    }
}


