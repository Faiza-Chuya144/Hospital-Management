package bd.edu.seu.hms.Controller.Receptionist;

import bd.edu.seu.hms.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepageReceptionistController implements Initializable {
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
    public void sceneChangeToPatient(){
        HelloApplication.sceneChange("add_patient");
    }
    @FXML
    public void logout(){
        HelloApplication.sceneChange("login");
    }
    @FXML
    public void createAppointment(){
        HelloApplication.sceneChange("create_appointment");
    }
    @FXML
    public void viewAppointment(){
        HelloApplication.sceneChange("view_appointment");
    }

    @FXML
    public void viewDoctor(){
        HelloApplication.sceneChange("view_doctor");
    }
}
