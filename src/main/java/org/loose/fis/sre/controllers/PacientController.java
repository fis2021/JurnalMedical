package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.loose.fis.sre.Main;
        import org.loose.fis.sre.services.UserService;
public class PacientController {
    public static Stage stg;
   @FXML
    public Text pacientMessage;

public void EmptyJournal(String s){
    if(UserService.CheckEmptyJournal(s)==1)
        pacientMessage.setText("Jurnal gol!");
}

    @FXML
    public void handleAddSimptomButtonAction() throws Exception{

        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("addSImptom.fxml"));
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
        try{
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getClassLoader().getResource("initialpage.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            LoginController.stg.close();
        }catch(Exception e){e.printStackTrace();}


        }


    }



