package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.MedicService;

public class RemovePacientController {
    @FXML
    public TextField pacField;
    @FXML
    public Text pacMessage;
    @FXML
    public static Stage stg;
    public void handleRemovePacientButtonAction() throws Exception{
        int q= MedicService.removePacient(LoginController.medic, pacField.getText());
        if(q==-1) pacMessage.setText("Nu exista pacienti in lista dumneavoastra!");
        else if(q==0)pacMessage.setText("Acest pacient nu exista in jurnalul dumneavoastra!");
        if(q==1)
            try {if(stg!=null)this.stg.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Medic.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                MedicController c=fxmlLoader.<MedicController>getController();
                c.EmptyJournal1(LoginController.medic);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                this.stg=stage;
                LoginController.stg.close();
               MedicController.remove1Stg.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    @FXML
    public void handleCancelMButtonAction(){
        MedicController.remove1Stg.close();
    }
}

