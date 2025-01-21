package bd.edu.seu.hms.Controller.Pharmacist;

import bd.edu.seu.hms.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepagePharmacistController implements Initializable {

    @FXML
    public Label nameField;

    @FXML
    public Label typeField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameField.setText(HelloApplication.loggedUser.getName());
        typeField.setText(HelloApplication.loggedUser.getUser());
    }
    public void createItem(){
        HelloApplication.sceneChange("create_item");
    }
    @FXML
    public void logout(){
        HelloApplication.sceneChange("login");
    }
    @FXML
    public void viewPrescription(){
        HelloApplication.sceneChange("view_prescription");
    }

    @FXML
    public void viewItem(){
        HelloApplication.sceneChange("view_item");
    }
    @FXML
    public void showReport(){
        HelloApplication.sceneChange("show_report");
    }
}
