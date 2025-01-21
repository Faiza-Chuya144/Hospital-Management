package bd.edu.seu.hms.Controller;

import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Service.RegistrationService;
import bd.edu.seu.hms.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public TextField nameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public TextField passwordFieldVisible;

    @FXML
    public CheckBox showPasswordCheckBox;

    @FXML
    public ComboBox<String> userField;

    @FXML
    public void login() {
        String name = nameField.getText();
        String password = showPasswordCheckBox.isSelected() ? passwordFieldVisible.getText() : passwordField.getText();
        String userType = userField.getValue();

        RegistrationService registrationInfo = new RegistrationService();
        User user = registrationInfo.login(name, password, userType.toLowerCase());
        if (user != null) {
            HelloApplication.loggedUser = user;
            switch (user.getUser()) {
                case "doctor":
                    HelloApplication.sceneChange("homepage_doctor");
                    break;
                case "receptionist":
                    HelloApplication.sceneChange("homepage_receptionist");
                    break;
                case "pharmacist":
                    HelloApplication.sceneChange("homepage_pharmacist");
                    break;
                default:
                    break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText(null);
            alert.setContentText("Failed to login.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> user = FXCollections.observableArrayList();
        user.add("Doctor");
        user.add("Receptionist");
        user.add("Pharmacist");
        userField.setItems(user);

        showPasswordCheckBox.setOnAction(event -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordFieldVisible.setText(passwordField.getText());
                passwordFieldVisible.setVisible(true);
                passwordField.setVisible(false);
            } else {
                passwordField.setText(passwordFieldVisible.getText());
                passwordField.setVisible(true);
                passwordFieldVisible.setVisible(false);
            }
        });
    }

    public void changeToRegister() {
        HelloApplication.sceneChange("register");
    }
}


