package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Medic;
import org.loose.fis.sre.services.MedicService;
public class MedicController {
    public static Stage stg,stgLogout,remove1Stg;
    @FXML
    public Text medicMessage;

    public void EmptyJournal1(String s){
        if(MedicService.CheckEmptyJournal1(s)==1)
            medicMessage.setText("Nici un pacient!");
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

        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("removePacient.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            remove1Stg=stage;
        }catch(Exception e){e.printStackTrace();}

    }
    @FXML
    public void handleViewJournalAction() {
        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("viewJurnal.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){e.printStackTrace();}
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
           if(AddPacientController.stg!=null)AddPacientController.stg.close();
        }catch(Exception e){e.printStackTrace();}

    }



}




