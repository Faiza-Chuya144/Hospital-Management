package bd.edu.seu.hms.Controller.Pharmacist;

import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Prescription;
import bd.edu.seu.hms.Service.PrescriptionService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class ViewPrescriptionController implements Initializable {

    @FXML
    public TableColumn<Prescription, String> appointmentNoCol;

    @FXML
    public TableColumn<Prescription, String> descriptionCol;

    @FXML
    public TableColumn<Prescription, String> diseasesTypeCol;

    @FXML
    public TableColumn<Prescription, String> doctorNameCol;

    @FXML
    public TableColumn<Prescription, String> patientNameCol;

    @FXML
    public TableColumn<Prescription, String> prescriptionNoCol;

    @FXML
    public TableView<Prescription> viewPrescriptionTable;
    private ObservableList<Prescription> prescriptionObservableList;

   @FXML
    void inventory() {
        Prescription selcetedPrescription = viewPrescriptionTable.getSelectionModel().getSelectedItem();
        if(selcetedPrescription != null){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/bd/edu/seu/hms/inventory.fxml"));
                Parent root = loader.load();

                InventoryController inventoryController = loader.getController();
                inventoryController.setSelectedPrescription(selcetedPrescription);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    @FXML
    public void close() {
        HelloApplication.sceneChange("homepage_pharmacist");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prescriptionNoCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrescriptionNo()));
        appointmentNoCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAppointmentNo()));
        doctorNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDoctorName()));
        patientNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPatientName()));
        diseasesTypeCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDiseasesType()));
        descriptionCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));

        prescriptionObservableList = FXCollections.observableArrayList();
        PrescriptionService prescriptionService = new PrescriptionService();
        prescriptionObservableList.addAll(prescriptionService.getPrescriptionList());
        viewPrescriptionTable.setItems(prescriptionObservableList);
    }
}
