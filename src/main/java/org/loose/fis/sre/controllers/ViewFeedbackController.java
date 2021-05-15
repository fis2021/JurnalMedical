package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.PacientService;

public class ViewFeedbackController {
    @FXML
    public Text feedbackMessage;
    public void viewFeedback(){
        if(PacientService.CheckNoFeedback(LoginController.pacient)==1)
            feedbackMessage.setText("Nu ati primit nici un feddback");
        else {

            feedbackMessage.setText(PacientService.viewFeedback(LoginController.pacient));
        }}
    public void handleBackAction(){
        PacientController.feedbackStg.close();
    }
}

