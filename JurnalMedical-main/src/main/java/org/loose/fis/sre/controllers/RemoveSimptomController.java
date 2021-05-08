package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.PacientService;

public class RemoveSimptomController {
    @FXML
    public TextField simptomField;
    @FXML
    public Text simptomMessage;
    @FXML
    public static Stage stg;
    public void handleRemoveSimptomButtonAction() throws Exception{
        int r=PacientService.removeSimptom(LoginController.pacient,simptomField.getText());
        if(r==-1) simptomMessage.setText("Jurnal gol!");
<<<<<<< HEAD
        else if(r==0)simptomMessage.setText("Acest simptom nu exista in jurnal!");
        if(r==1)
            try {if(stg!=null)this.stg.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Pacient.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                PacientController c=fxmlLoader.<PacientController>getController();
                c.EmptyJournal(LoginController.pacient);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                this.stg=stage;
                LoginController.stg.close();
                PacientController.removeStg.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
=======
            else if(r==0)simptomMessage.setText("Acest simptom nu exista in jurnal!");
        if(r==1)
            try {if(stg!=null)this.stg.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Pacient.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PacientController c=fxmlLoader.<PacientController>getController();
            c.EmptyJournal(LoginController.pacient);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            this.stg=stage;
            LoginController.stg.close();
            PacientController.removeStg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> b42c8ba474ed51ea5e7b39f503a9d7df6ce26948
    }
    @FXML
    public void handleCancelButtonAction(){
        PacientController.removeStg.close();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> b42c8ba474ed51ea5e7b39f503a9d7df6ce26948
