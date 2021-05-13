package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Pacient;
import org.loose.fis.sre.services.PacientService;

import java.io.IOException;

public class PacientJournalController {
    public static Stage stg;
    @FXML
    public Text pacientMessage;

    public void EmptyJournal(String s){
        if(PacientService.CheckEmptyJournal(s)==1)
            pacientMessage.setText("Jurnal gol!");
        else
         {Pacient p=PacientService.getPacient(ViewJurnalController.pacient);
           String r="";
           for(int j=0;j<p.getNr_simptome();j++)r=r+p.getSimptome()[j]+"\n";
            pacientMessage.setText(r);
        }
}
    @FXML
    public void handleSendFeedbackAction() throws IOException {
        try {
            if(stg!=null)stg.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("sendFeedback.fxml"));
        Parent root = (Parent) fxmlLoader.load();
         SendFeedbackController t=fxmlLoader.<SendFeedbackController>getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        this.stg=stage;

        LoginController.stg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void handleCancelMButtonAction(){
        MedicController.remove1Stg.close();
    }



}



