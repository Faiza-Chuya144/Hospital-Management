package bd.edu.seu.hms.Controller.Doctor;

import bd.edu.seu.hms.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepageDoctorController implements Initializable {
    @FXML
    public Label nameField;

    @FXML
    public Label typeField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameField.setText(HelloApplication.loggedUser.getName());
        typeField.setText(HelloApplication.loggedUser.getUser());
    }

    @FXML
    public void logout(){
        HelloApplication.sceneChange("login");
    }
    @FXML
    public void changeToDoctor(){
        HelloApplication.sceneChange("doctor");
    }
    @FXML
    public void viewAppointment(){
        HelloApplication.sceneChange("view_appointment");
    }

}
