package org.loose.fis.sre.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import org.loose.fis.sre.services.UserService;
        import org.loose.fis.sre.model.User;
        import javafx.fxml.FXMLLoader;
public class PacientController {
   @FXML
    public Text pacientMessage;

public void EmptyJournal(String s){
    if(UserService.CheckEmptyJournal(s)==1)
        pacientMessage.setText("Jurnal gol!");
}

    @FXML
    public void handleAddSimptomButtonAction(){


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



