package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.MedicService;
public class ViewJurnalController {
    @FXML
    public TextField pacField;
    @FXML
    public Text pacMessage;
    @FXML
    public static Stage stg;
    public static String pacient;
    public void handleViewJurnalButtonAction() throws Exception{

    pacient=pacField.getText();
        int q= MedicService.viewJurnal(LoginController.medic,pacField.getText());
        if(q==-1) pacMessage.setText("Acest pacient nu se afla in jurnalul dumneavoastra");
            if(q==0)pacMessage.setText("Acest pacient nu are cont");
        if(q==1)
            {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("pacientJournal.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    PacientJournalController c=fxmlLoader.<PacientJournalController>getController();
                    c.EmptyJournal(pacField.getText());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                    this.stg=stage;
                    InitialPageController.stg.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
            }

    public void handleCancelMButtonAction(){

    }

}