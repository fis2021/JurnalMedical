package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.services.MedicService;
import javafx.scene.text.Text;

public class AddPacientController {
    @FXML
    public TextField pacientField;
    @FXML
    public Text pacientMessage;
    @FXML
    public static Stage stg;
    public void handleAddPacientButtonAction() throws Exception{
        int g=MedicService.addPacient(LoginController.medic,pacientField.getText());
        if(g==0) pacientMessage.setText("Pacientul nu este inregistrat!");
        if(g==1)try {if(stg!=null)stg.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Medic.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            MedicController d=fxmlLoader.<MedicController>getController();
            d.EmptyJournal1(LoginController.medic);
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
