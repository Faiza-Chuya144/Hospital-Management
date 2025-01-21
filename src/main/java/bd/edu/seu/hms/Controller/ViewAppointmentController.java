package bd.edu.seu.hms.Controller;
import bd.edu.seu.hms.Controller.Doctor.PrescriptionController;
import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Appointment;
import bd.edu.seu.hms.Service.AppointmentService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAppointmentController implements Initializable {

    @FXML
    public TableColumn<Appointment, String> appointmentNoCol;

    @FXML
    public TableView<Appointment> appointmentTable;

    @FXML
    public TableColumn<Appointment, String> dateCol;

    @FXML
    public TableColumn<Appointment, String> doctorNameCol;

    @FXML
    public TableColumn<Appointment, String> patientNameCol;

    @FXML
    public TableColumn<Appointment, String> roomCol;
    @FXML
    public ObservableList<Appointment> appointmentObservableList;
    @FXML
    public Button prescription;
    @FXML
    public void close(){

        if (HelloApplication.loggedUser != null) {
            String user = HelloApplication.loggedUser.getUser();
            if (user.equals("receptionist")) {
                HelloApplication.sceneChange("homepage_receptionist");
            } else if (user.equals("doctor")) {
                HelloApplication.sceneChange("homepage_doctor");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("No user logged in!");
            alert.showAndWait();
        }
    }


    @FXML
    public void prescription() {
        Appointment selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/bd/edu/seu/hms/prescription.fxml"));
                Parent root = loader.load();

                PrescriptionController prescriptionController = loader.getController();
                prescriptionController.setSelectedAppointment(selectedAppointment);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void refreshAppointments() {
        appointmentObservableList.clear();
        if (HelloApplication.loggedUser != null) {
            String user = HelloApplication.loggedUser.getUser();
            if (user.equals("receptionist")) {
                loadAllAppointments();
            } else if (user.equals("doctor")) {
                String doctorName = HelloApplication.loggedUser.getName();
                loadDoctorAppointments(doctorName);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentNoCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAppointmentNo()));
        doctorNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDoctorName()));
        patientNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPatientName()));
        roomCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRoom()));
        dateCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDate()));

        appointmentObservableList = FXCollections.observableArrayList();


        if (HelloApplication.loggedUser != null) {
            String user = HelloApplication.loggedUser.getUser();
            if (user.equals("receptionist")) {
                loadAllAppointments();
                prescription.setVisible(false);

            } else if (user.equals("doctor")) {

                String doctorName = HelloApplication.loggedUser.getName();
                loadDoctorAppointments(doctorName);
            }
        }

        appointmentTable.setItems(appointmentObservableList);
        refreshAppointments();
    }

    private void loadAllAppointments() {
        AppointmentService appointmentService = new AppointmentService();
        appointmentObservableList.addAll(appointmentService.getAppointmentList());
    }

    private void loadDoctorAppointments(String doctorName) {
        AppointmentService appointmentService = new AppointmentService();
        appointmentObservableList.addAll(appointmentService.getAppointmentsForDoctor(doctorName));
    }
}
