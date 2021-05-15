package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.SimptomAlreadyExistsException;
import org.loose.fis.sre.services.PacientService;

public class AddSimptomController {
    @FXML
    public TextField simptomField;
    @FXML
    public static Stage stg;
    @FXML
    private Text simptomMessage;
    public void handleAddSimptomButtonAction() throws Exception{

       try {
           PacientService.addSimptom(LoginController.pacient, simptomField.getText());

        if(stg!=null)stg.close();
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
        } catch(SimptomAlreadyExistsException e){simptomMessage.setText(e.getMessage());}
           catch (Exception e) {
            e.printStackTrace();
        }
           }
    @FXML
    public void handleCancelButtonAction(){
        PacientController.stg.close();
    }
}
