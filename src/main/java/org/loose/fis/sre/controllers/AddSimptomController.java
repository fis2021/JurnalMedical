package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import org.loose.fis.sre.Main;

public class AddSimptomController {

    @FXML
    public void handleAddSimptomButtonAction(){
    }
    @FXML
    public void handleCancelButtonAction(){
        PacientController.stg.close();
    }
}
