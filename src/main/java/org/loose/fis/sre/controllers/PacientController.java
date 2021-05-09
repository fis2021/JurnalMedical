package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Pacient;
import org.loose.fis.sre.services.PacientService;

public class PacientController {
    public static Stage stg,stgLogout,removeStg,feedbackStg;
   @FXML
    public Text pacientMessage;

public void EmptyJournal(String s){
    if(PacientService.CheckEmptyJournal(s)==1)
        pacientMessage.setText("Jurnal gol!");
    else {Pacient p=PacientService.getPacient(LoginController.pacient);
    String r="";
    for(int j=0;j<p.getNr_simptome();j++)r=r+p.getSimptome()[j]+"\n";
        pacientMessage.setText(r);
}}

    @FXML
    public void handleAddSimptomButtonAction() throws Exception{

        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("addSimptom.fxml"));
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
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("removeSimptom.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            removeStg=stage;
        }catch(Exception e){e.printStackTrace();}


    }
    @FXML
    public void handleViewFeedbackAction() {

        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("viewFeedback.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            ViewFeedbackController c=fxmlLoader.<ViewFeedbackController>getController();
            c.viewFeedback();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            feedbackStg=stage;
        }catch(Exception e){e.printStackTrace();}

    }
    @FXML
    public void handleLogoutAction() throws Exception{
        try{if(stgLogout!=null)
            stgLogout.close();
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("initialpage.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stgLogout=stage;
            LoginController.stg.close();
            if(AddSimptomController.stg!=null)AddSimptomController.stg.close();
            if(RemoveSimptomController.stg!=null)RemoveSimptomController.stg.close();
        }catch(Exception e){e.printStackTrace();}

        }


    }



