package org.loose.fis.sre.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.Main;
import org.loose.fis.sre.model.Medic;
import org.loose.fis.sre.services.MedicService;
import org.loose.fis.sre.services.PacientService;
import org.loose.fis.sre.model.Pacient;
public class MedicController {
    public static Stage stg,stgLogout;
    @FXML
    public Text medicMessage;

    public void EmptyJournal(String s){
        if(MedicService.CheckEmptyJournal1(s)==1)
            medicMessage.setText("Jurnal gol!");
        else {Medic m=MedicService.getMedic(LoginController.medic);
            String r="";
            for(int j=0;j<m.getNr_pacienti();j++)r=r+m.getPacienti()[j]+"\n";
            medicMessage.setText(r);
        }}

    @FXML
    public void handleAddPacientButtonAction() throws Exception{

        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("addPacient.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            this.stg=stage;
        }catch(Exception e){e.printStackTrace();}

    }

    @FXML
    public void handleRemoveSimptomAction() {



    }
    @FXML
    public void handleViewFeedbackAction() {



    }
    @FXML
    public void handleLogoutAction() throws Exception{
        try{if(stgLogout!=null)stgLogout.close();
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("initialpage.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stgLogout=stage;
            LoginController.stg.close();
            AddSimptomController.stg.close();
        }catch(Exception e){e.printStackTrace();}

    }


}




