package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.loose.fis.sre.services.PacientService;

public class AddSimptomController {
    @FXML
    public TextField simptomField;
    @FXML

    public void handleAddSimptomButtonAction(){
      //  PacientService.addSimptom("pacient",simptomField.getText());
      //  PacientService.ViewSimptoms("pacient");
    }
    @FXML
    public void handleCancelButtonAction(){
        PacientController.stg.close();
    }
}
