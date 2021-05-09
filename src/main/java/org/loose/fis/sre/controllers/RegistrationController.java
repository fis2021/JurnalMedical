package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.MedicService;
import org.loose.fis.sre.services.PacientService;
import org.loose.fis.sre.services.UserService;
public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Pacient", "Medic");
    }

    @FXML
    public void handleRegisterButtonAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
            if ((String) role.getValue()=="Pacient")PacientService.addPacient(usernameField.getText());
            if ((String) role.getValue()=="Medic") MedicService.addMedic(usernameField.getText());
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
