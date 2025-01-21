package bd.edu.seu.hms.Controller.Receptionist;
import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Appointment;
import bd.edu.seu.hms.Model.Doctor;
import bd.edu.seu.hms.Model.Patient;
import bd.edu.seu.hms.Service.AppointmentService;
import bd.edu.seu.hms.Service.DoctorService;
import bd.edu.seu.hms.Service.PatientService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateAppointmentController implements Initializable {

    @FXML
    public TableColumn<Appointment, String> dateCol;

    @FXML
    public TableColumn<Appointment, String> appointmentNoCol;

    @FXML
    public TextField appointmentNoField;

    @FXML
    public TableView<Appointment> appointmentTable;

    @FXML
    public DatePicker dateField;

    @FXML
    public TableColumn<Appointment, String> doctorNameCol;

    @FXML
    public ChoiceBox<String> doctorNameField;

    @FXML
    public TableColumn<Appointment, String> patientNameCol;

    @FXML
    public ChoiceBox<String> patientNameField;

    @FXML
    public TableColumn<Appointment, String> roomCol;

    @FXML
    public TextField roomField;

    @FXML
    public Appointment selectedAppointment;
    @FXML
    public ObservableList<Appointment> appointmentObservableList;

    @FXML
    public void create() {
       String appointmentNo = appointmentNoField.getText();
       String doctorName = doctorNameField.getValue();
       String patientName = patientNameField.getValue();
       String room = roomField.getText();
       String date = dateField.getValue().toString();

        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment(appointmentNo, doctorName , patientName, room, date);
        boolean isCreated = appointmentService.create(appointment);
        if(isCreated){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Created an Appointment Successfully.");
            alert.showAndWait();
            appointmentObservableList.add(appointment);

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setHeaderText("Failed to create an Appointment.");
            alert.showAndWait();
        }
    }

    @FXML
    public void delete(){
      if(selectedAppointment != null){
          AppointmentService appointmentService = new AppointmentService();
          boolean isDeleted = appointmentService.delete(selectedAppointment.getAppointmentNo());
          if(isDeleted){
              appointmentObservableList.remove(selectedAppointment);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
              alert.setHeaderText(null);
              alert.setContentText("Appointment Deleted Successfully.");
              alert.showAndWait();
              clearFields();
          }else {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error");
              alert.setHeaderText(null);
              alert.setContentText("Failed to Delete Appointment.");
              alert.showAndWait();
          }
      }
    }
    @FXML
    public void clear() {
      clearFields();
    }
    private void clearFields(){
        appointmentNoField.setText("");
        doctorNameField.setValue("");
        patientNameField.setValue("");
        roomField.setText("");
        dateField.setValue(null);
    }

    @FXML
    public void exit() {
        HelloApplication.sceneChange("homepage_receptionist");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentNoCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAppointmentNo()));
        doctorNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDoctorName()));
        patientNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPatientName()));
        roomCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRoom()));
        dateCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDate()));

        appointmentObservableList = FXCollections.observableArrayList();
        AppointmentService appointmentService = new AppointmentService();
        appointmentObservableList.addAll(appointmentService.getAppointmentList());
        appointmentTable.setItems(appointmentObservableList);

        appointmentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedAppointment = newValue;
            displaySelectedAppointment();
        });

        dateField.setValue(LocalDate.now());

        loadDoctorNames();
        loadPatientNames();

    }

    private void loadDoctorNames(){
        DoctorService doctorService = new DoctorService();
        ObservableList<String> doctorNames = FXCollections.observableArrayList();
        for(Doctor doctor : doctorService.getDoctorList()){
            doctorNames.add(doctor.getName());
        }
        doctorNameField.setItems(doctorNames);
    }

    private void loadPatientNames(){
        PatientService patientService = new PatientService();
        ObservableList<String> patientNames =FXCollections.observableArrayList();
        for(Patient patient : patientService.getPatientList()){
            patientNames.add(patient.getName());
        }
        patientNameField.setItems(patientNames);
    }

    private void displaySelectedAppointment() {
        if (selectedAppointment != null) {
            appointmentNoField.setText(selectedAppointment.getAppointmentNo());
            doctorNameField.setValue(selectedAppointment.getPatientName());
            patientNameField.setValue(selectedAppointment.getPatientName());
            roomField.setText(selectedAppointment.getRoom());
            dateField.setValue(LocalDate.parse(selectedAppointment.getDate()));
        }
    }
}
