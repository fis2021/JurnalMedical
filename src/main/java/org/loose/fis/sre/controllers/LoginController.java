package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.UserService;

public class LoginController {

    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    public void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty()) {
            loginMessage.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Password cannot be empty");
            return;
        }

        if (UserService.CheckCredentialsOk(username,password)==1) {
            loginMessage.setText("Logare ca si pacient!");
            return;
        }

        if (UserService.CheckCredentialsOk(username,password)==2) {
            loginMessage.setText("Logare ca si medic!");
            return;
        }
        loginMessage.setText("Incorrect login!");
    }
}
