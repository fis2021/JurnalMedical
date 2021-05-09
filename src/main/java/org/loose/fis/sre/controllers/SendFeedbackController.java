package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.MedicService;

public class SendFeedbackController {

    @FXML
    public TextField feedbackField;
    @FXML
    public Text feedbackMessage;
    public void handleCancelMButtonAction(){

    }
    public void handleAddFeeedbackButtonAction(){
        MedicService.sendFeedback(LoginController.medic,ViewJurnalController.pacient,feedbackField.getText());
        feedbackMessage.setText("Feedbackul a fost trimis");}
}
