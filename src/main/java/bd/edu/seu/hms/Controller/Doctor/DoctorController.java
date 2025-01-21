/*package bd.edu.seu.hms.Controller.Doctor;
import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Doctor;
import bd.edu.seu.hms.Service.DoctorService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    @FXML
    public TableView<Doctor> doctorTable;

    @FXML
    public TableColumn<Doctor, Number> feeCol;

    @FXML
    public TextField feeField;

    @FXML
    public TableColumn<Doctor, String> idCol;

    @FXML
    public TextField idField;

    @FXML
    public TableColumn<Doctor, String> nameCol;

    @FXML
    public TextField nameField;

    @FXML
    public TableColumn<Doctor, String> phoneCol;

    @FXML
    public TextField phoneField;

    @FXML
    public TableColumn<Doctor, String> qualificationCol;

    @FXML
    public TextField qualificationField;

    @FXML
    public TableColumn<Doctor, String> roomCol;


    @FXML
    public TextField roomField;

    @FXML
    public TableColumn<Doctor, String> specializationCol;

    @FXML
    public TextField specializationField;
    @FXML
    public ImageView doctorImage;
    @FXML
    public TableColumn<Doctor, String> imageCol;
    @FXML
    public Button uploadImage;


    @FXML
    public Doctor selectedDoctor;

    private ObservableList<Doctor> doctorObservableList;

    @FXML
    public void save() {
        String id = idField.getText();
        String name = nameField.getText();
        String specialization = specializationField.getText();
        String qualification = qualificationField.getText();
        double fee = Double.parseDouble(feeField.getText());
        String phone = phoneField.getText();
        String room = roomField.getText();


        DoctorService doctorService = new DoctorService();
        Doctor doctor = new Doctor(id, name, specialization, qualification, fee, phone, room);

        boolean isSaved = doctorService.save(doctor);
        if (isSaved) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Doctor saved successfully.");
            alert.showAndWait();

            doctorObservableList.add(doctor);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the Doctor.");
            alert.showAndWait();
        }
    }

    @FXML
    public void update () {
        if (selectedDoctor != null) {
            selectedDoctor.setId(idField.getText());
            selectedDoctor.setName(nameField.getText());
            selectedDoctor.setSpecialization(specializationField.getText());
            selectedDoctor.setQualification(qualificationField.getText());
            selectedDoctor.setFee(Double.parseDouble(feeField.getText()));
            selectedDoctor.setPhone(phoneField.getText());
            selectedDoctor.setRoom(roomField.getText());
            DoctorService doctorService = new DoctorService();
            boolean isUpdated = doctorService.update(selectedDoctor);
            if (isUpdated) {
                doctorTable.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Doctor updated successfully.");
                alert.showAndWait();

                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to update the Doctor.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void delete() {
        if (selectedDoctor != null) {
            DoctorService doctorService = new DoctorService();
            boolean isDeleted = doctorService.delete(selectedDoctor.getId());
            if (isDeleted) {
                doctorObservableList.remove(selectedDoctor);
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
    private void clearFields(){
        idField.setText("");
        nameField.setText("");
        specializationField.setText("");
        qualificationField.setText("");
        feeField.setText("");
        phoneField.setText("");
        roomField.setText("");
    }

    @FXML
    public void exit () {
        HelloApplication.sceneChange("homepage_doctor");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        specializationCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSpecialization()));
        qualificationCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getQualification()));
        feeCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getFee()));
        phoneCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhone()));
        roomCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRoom()));

        doctorObservableList = FXCollections.observableArrayList();
        DoctorService doctorService = new DoctorService();
        doctorObservableList.addAll(doctorService.getDoctorList());
        doctorTable.setItems(doctorObservableList);

        doctorTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedDoctor = newValue;
            displaySelectedDoctor();
        });
    }
    private void displaySelectedDoctor() {
        if (selectedDoctor != null) {
            idField.setText(selectedDoctor.getId());
            nameField.setText(selectedDoctor.getName());
            specializationField.setText(selectedDoctor.getSpecialization());
            qualificationField.setText(selectedDoctor.getQualification());
            feeField.setText(Double.toString(selectedDoctor.getFee()));
            phoneField.setText(selectedDoctor.getPhone());
            roomField.setText(selectedDoctor.getRoom());

        }
    }

}*/

package bd.edu.seu.hms.Controller.Doctor;

import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Doctor;
import bd.edu.seu.hms.Service.DoctorService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController implements Initializable {
    @FXML
    public TableView<Doctor> doctorTable;

    @FXML
    public TableColumn<Doctor, Number> feeCol;

    @FXML
    public TextField feeField;

    @FXML
    public TableColumn<Doctor, String> idCol;

    @FXML
    public TextField idField;

    @FXML
    public TableColumn<Doctor, String> nameCol;

    @FXML
    public TextField nameField;

    @FXML
    public TableColumn<Doctor, String> phoneCol;

    @FXML
    public TextField phoneField;

    @FXML
    public TableColumn<Doctor, String> qualificationCol;

    @FXML
    public TextField qualificationField;

    @FXML
    public TableColumn<Doctor, String> roomCol;

    @FXML
    public TextField roomField;

    @FXML
    public TableColumn<Doctor, String> specializationCol;

    @FXML
    public TextField specializationField;

    @FXML
    public Doctor selectedDoctor;

    private ObservableList<Doctor> doctorObservableList;


    @FXML
    public void save() {
        String id = idField.getText();
        String name = nameField.getText();
        String specialization = specializationField.getText();
        String qualification = qualificationField.getText();
        double fee = Double.parseDouble(feeField.getText());
        String phone = phoneField.getText();
        String room = roomField.getText();

        DoctorService doctorService = new DoctorService();
        Doctor doctor = new Doctor(id, name, specialization, qualification, fee, phone, room);

        boolean isSaved = doctorService.save(doctor);
        if (isSaved) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Doctor saved successfully.");
            alert.showAndWait();

            doctorObservableList.add(doctor);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save the Doctor.");
            alert.showAndWait();
        }
    }

    @FXML
    public void update() {
        if (selectedDoctor != null) {
            selectedDoctor.setId(idField.getText());
            selectedDoctor.setName(nameField.getText());
            selectedDoctor.setSpecialization(specializationField.getText());
            selectedDoctor.setQualification(qualificationField.getText());
            selectedDoctor.setFee(Double.parseDouble(feeField.getText()));
            selectedDoctor.setPhone(phoneField.getText());
            selectedDoctor.setRoom(roomField.getText());

            DoctorService doctorService = new DoctorService();
            boolean isUpdated = doctorService.update(selectedDoctor);
            if (isUpdated) {
                doctorTable.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Doctor updated successfully.");
                alert.showAndWait();

                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to update the Doctor.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void delete() {
        if (selectedDoctor != null) {
            DoctorService doctorService = new DoctorService();
            boolean isDeleted = doctorService.delete(selectedDoctor.getId());
            if (isDeleted) {
                doctorObservableList.remove(selectedDoctor);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Doctor deleted successfully.");
                alert.showAndWait();

                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete the Doctor.");
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
        specializationField.setText("");
        qualificationField.setText("");
        feeField.setText("");
        phoneField.setText("");
        roomField.setText("");

    }

    @FXML
    public void exit() {
        HelloApplication.sceneChange("homepage_doctor");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        specializationCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSpecialization()));
        qualificationCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getQualification()));
        feeCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getFee()));
        phoneCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhone()));
        roomCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRoom()));


        doctorObservableList = FXCollections.observableArrayList();
        DoctorService doctorService = new DoctorService();
        doctorObservableList.addAll(doctorService.getDoctorList());
        doctorTable.setItems(doctorObservableList);

        doctorTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedDoctor = newValue;
            displaySelectedDoctor();
        });
    }

    private void displaySelectedDoctor() {
        if (selectedDoctor != null) {
            idField.setText(selectedDoctor.getId());
            nameField.setText(selectedDoctor.getName());
            specializationField.setText(selectedDoctor.getSpecialization());
            qualificationField.setText(selectedDoctor.getQualification());
            feeField.setText(Double.toString(selectedDoctor.getFee()));
            phoneField.setText(selectedDoctor.getPhone());
            roomField.setText(selectedDoctor.getRoom());

        }
    }
}
