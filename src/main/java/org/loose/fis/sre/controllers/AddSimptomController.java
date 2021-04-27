package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.services.PacientService;

public class AddSimptomController {
    @FXML
    public TextField simptomField;
    @FXML
    public static Stage stg;
    public void handleAddSimptomButtonAction() throws Exception{
        PacientService.addSimptom(LoginController.pacient,simptomField.getText());
        try {if(stg!=null)stg.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Pacient.fxml"));
        Parent root = (Parent) fxmlLoader.load();
            PacientController c=fxmlLoader.<PacientController>getController();
            c.EmptyJournal(LoginController.pacient);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
            this.stg=stage;
        LoginController.stg.close();
            PacientController.stg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void handleCancelButtonAction(){
        PacientController.stg.close();
    }
}
