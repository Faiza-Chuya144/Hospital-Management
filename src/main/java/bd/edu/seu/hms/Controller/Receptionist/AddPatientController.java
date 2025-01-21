package bd.edu.seu.hms.Controller.Receptionist;
import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Patient;
import bd.edu.seu.hms.Service.PatientService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPatientController implements Initializable {

    @FXML
    public TableColumn<Patient, String> addressColumn;

    @FXML
    public TextArea addressField;

    @FXML
    public TableColumn<Patient, String> idColumn;

    @FXML
    public TextField idField;

    @FXML
    public TableColumn<Patient, String> nameColumn;

    @FXML
    public TextField nameField;

    @FXML
    public TableColumn<Patient, String> phoneColumn;

    @FXML
    public TextField phoneField;
    @FXML
    public ToggleGroup genderToggleGroup;
    @FXML
    public TableColumn<Patient, String> genderColumn;
    @FXML
    public Patient selectedPatient;
    @FXML
    public TableView<Patient> patientTable;
    private ObservableList<Patient> patientObservableList;

    @FXML
    public void exit(){
        HelloApplication.sceneChange("homepage_receptionist");
    }

    @FXML
    public void save() {

        String id = idField.getText();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        RadioButton genderRadio = (RadioButton) genderToggleGroup.getSelectedToggle();
        String gender = genderRadio.getText();


        PatientService patientService = new PatientService();
        Patient patient = new Patient(id, name, phone, address,gender);

        boolean isSaved = patientService.save(patient);
        if (isSaved) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Patient saved successfully.");
            alert.showAndWait();

            patientObservableList.add(patient);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the patient.");
            alert.showAndWait();
        }
    }

    @FXML
    public void update() {
        if (selectedPatient != null) {
            selectedPatient.setId(idField.getText());
            selectedPatient.setName(nameField.getText());
            selectedPatient.setPhone(phoneField.getText());
            selectedPatient.setAddress(addressField.getText());

            RadioButton genderRadio = (RadioButton) genderToggleGroup.getSelectedToggle();
            String gender = genderRadio.getText();
            selectedPatient.setGender(gender);


            PatientService patientService = new PatientService();
            boolean isUpdated = patientService.update(selectedPatient);
            if (isUpdated) {
                patientTable.refresh(); // Refresh the TableView
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Patient updated successfully.");
                alert.showAndWait();

                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to update the patient.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void delete() {
        if (selectedPatient != null) {
            PatientService patientService = new PatientService();
            boolean isDeleted = patientService.delete(selectedPatient.getId());
            if (isDeleted) {
                patientObservableList.remove(selectedPatient);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Patient deleted successfully.");
                alert.showAndWait();

                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete the patient.");
                alert.showAndWait();
            }
        }
    }


    @FXML
    public void clear() {
        clearFields();
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        if (genderToggleGroup.getSelectedToggle() != null) {
            genderToggleGroup.getSelectedToggle().setSelected(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        phoneColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhone()));
        addressColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAddress()));
        genderColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGender()));

        patientObservableList = FXCollections.observableArrayList();
        PatientService patientService = new PatientService();
        patientObservableList.addAll(patientService.getPatientList());
        patientTable.setItems(patientObservableList);


        patientTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedPatient = newValue;
            displaySelectedPatient();
        });

    }

    private void displaySelectedPatient() {
        if (selectedPatient != null) {
            idField.setText(selectedPatient.getId());
            nameField.setText(selectedPatient.getName());
            phoneField.setText(selectedPatient.getPhone());
            addressField.setText(selectedPatient.getAddress());

            // Set gender toggle group based on selected patient's gender
            for (Toggle toggle : genderToggleGroup.getToggles()) {
                RadioButton radioButton = (RadioButton) toggle;
                if (radioButton.getText().equals(selectedPatient.getGender())) {
                    radioButton.setSelected(true);
                    break;
                }
            }
        }
    }
}


