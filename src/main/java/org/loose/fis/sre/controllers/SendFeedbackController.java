package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.MedicService;

public class SendFeedbackController {

    @FXML
    public TextArea feedbackField;
    @FXML
    public Text feedbackMessage;
    public void handleCancelMButtonAction(){
        PacientJournalController.stg.close();
    }
    public void handleAddFeeedbackButtonAction(){
        MedicService.sendFeedback(LoginController.medic,ViewJurnalController.pacient,feedbackField.getText());
        feedbackMessage.setText("Feedbackul a fost trimis");}
}
