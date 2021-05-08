package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.MedicService;

import java.net.URL;
import java.util.ResourceBundle;

public class PacientJournalController implements Initializable {

    @FXML
    private Text pacientSymptoms;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String symptoms = MedicService.getPacientSymptoms(LoginController.medic);
        System.out.println(symptoms);
    }
}
