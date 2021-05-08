package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.UserService;
public class LoginController {
    public static Stage stg;
    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    public static String pacient,medic;
    @FXML
    public void handleLoginButtonAction() throws Exception{
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
            pacient=username;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Pacient.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                PacientController c=fxmlLoader.<PacientController>getController();
                c.EmptyJournal(username);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                this.stg=stage;
                InitialPageController.stg.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return ;
        }

        if (UserService.CheckCredentialsOk(username,password)==2) {
            medic=username;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Medic.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                MedicController d=fxmlLoader.<MedicController>getController();
                d.EmptyJournal1(username);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                this.stg=stage;
                InitialPageController.stg.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return ;
        }
        loginMessage.setText("Incorrect login!");
    }

    public void Cancel() throws Exception {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("initialpage.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            InitialPageController.stg.close();

        } catch (Exception e) {
            e.printStackTrace();
        }}}

