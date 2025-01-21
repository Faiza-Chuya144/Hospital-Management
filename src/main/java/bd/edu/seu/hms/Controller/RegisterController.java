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

public class RegisterController implements Initializable {

    @FXML
    public TextField emailField;

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
    void sighup() {
        String email = emailField.getText();
        String name = nameField.getText();
        String password = showPasswordCheckBox.isSelected() ? passwordFieldVisible.getText() : passwordField.getText();
        String selectUser = userField.getValue();

        User user = new User(email, name, password, selectUser);
        RegistrationService registrationInfo = new RegistrationService();
        boolean isRegistered = registrationInfo.signup(user);
        if (isRegistered) {
            HelloApplication.sceneChange("login");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setContentText("Failed to Register.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> userInfo = FXCollections.observableArrayList();
        userInfo.add("Doctor");
        userInfo.add("Receptionist");
        userInfo.add("Pharmacist");
        userField.setItems(userInfo);


        showPasswordCheckBox.setOnAction(event -> {
            if(showPasswordCheckBox.isSelected()){
                passwordFieldVisible.setText(passwordField.getText());
                passwordFieldVisible.setVisible(true);
                passwordField.setVisible(false);
            }else {
                passwordFieldVisible.setText(passwordField.getText());
                passwordFieldVisible.setVisible(true);
                passwordField.setVisible(false);
            }
        });

    }

    @FXML
    public void changeToLogin() {
        HelloApplication.sceneChange("login");
    }
}

