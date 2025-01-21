/*package bd.edu.seu.hms.Controller;
import bd.edu.seu.hms.Model.Appointment;
import bd.edu.seu.hms.Model.Prescription;
import bd.edu.seu.hms.Service.PrescriptionService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrescriptionController {

    @FXML
    public  TextField appointmentNoField;

    @FXML
    public TextArea descriptionField;

    @FXML
    public TextField diseaseTypeField;

    @FXML
    public TextField prescriptionNoField;
    @FXML
    public TextField doctorNameField;

    @FXML
    public TextField patientNameField;

    public Appointment selectedAppointment;
    private static int prescriptionCounter = 1;



    public void setSelectedAppointment(Appointment appointment) {
        selectedAppointment = appointment;
        appointmentNoField.setText(selectedAppointment.getAppointmentNo());
        doctorNameField.setText(selectedAppointment.getDoctorName());
        patientNameField.setText(selectedAppointment.getPatientName());

        // Generate prescription number
        prescriptionNoField.setText("" + prescriptionCounter);
    }
    public void setSelectedPrescription(Prescription prescription) {
        if (prescription != null) {
            prescriptionNoField.setText(prescription.getPrescriptionNo());
            appointmentNoField.setText(prescription.getAppointmentNo());
            doctorNameField.setText(prescription.getDoctorName());
            patientNameField.setText(prescription.getPatientName());
            diseaseTypeField.setText(prescription.getDiseasesType());
            descriptionField.setText(prescription.getDescription());
        }
    }


    @FXML
    public void create() {
       String prescriptionNo = prescriptionNoField.getText();
       String appointmentNo = appointmentNoField.getText();
       String doctorName = doctorNameField.getText();
       String patientName = patientNameField.getText();
       String disease = diseaseTypeField.getText();
       String description = descriptionField.getText();

        PrescriptionService prescriptionService = new PrescriptionService();
        Prescription prescription = new Prescription(prescriptionNo, appointmentNo, doctorName, patientName, disease, description);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Prescription Inserted!");
        alert.showAndWait();
        prescriptionService.create(prescription);

        // Increment prescription counter for the next prescription
        prescriptionCounter++;
    }
   @FXML
   public void close(){
       Stage stage = (Stage) appointmentNoField.getScene().getWindow();
       stage.close();
   }
}*/
package bd.edu.seu.hms.Controller.Doctor;

import bd.edu.seu.hms.Model.Appointment;
import bd.edu.seu.hms.Model.Prescription;
import bd.edu.seu.hms.Service.PrescriptionService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrescriptionController {

    @FXML
    public TextField appointmentNoField;

    @FXML
    public TextArea descriptionField;

    @FXML
    public TextField diseaseTypeField;

    @FXML
    public TextField prescriptionNoField;
    @FXML
    public TextField doctorNameField;

    @FXML
    public TextField patientNameField;

    public Appointment selectedAppointment;
    private static int prescriptionCounter = 1;

    public void setSelectedAppointment(Appointment appointment) {
        selectedAppointment = appointment;
        appointmentNoField.setText(selectedAppointment.getAppointmentNo());
        doctorNameField.setText(selectedAppointment.getDoctorName());
        patientNameField.setText(selectedAppointment.getPatientName());

        // Generate prescription number
        prescriptionNoField.setText("" + prescriptionCounter);
    }



    @FXML
    public void create() {
        String prescriptionNo = prescriptionNoField.getText();
        String appointmentNo = appointmentNoField.getText();
        String doctorName = doctorNameField.getText();
        String patientName = patientNameField.getText();
        String disease = diseaseTypeField.getText();
        String description = descriptionField.getText();

        PrescriptionService prescriptionService = new PrescriptionService();
        Prescription prescription = new Prescription(prescriptionNo, appointmentNo, doctorName, patientName, disease, description);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Prescription Inserted!");
        alert.showAndWait();
        prescriptionService.create(prescription);

        // Increment prescription counter for the next prescription
        prescriptionCounter++;
    }

    @FXML
    public void close() {
        Stage stage = (Stage) appointmentNoField.getScene().getWindow();
        stage.close();
    }

}

