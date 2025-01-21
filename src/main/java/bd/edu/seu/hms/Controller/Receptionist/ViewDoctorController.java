package bd.edu.seu.hms.Controller.Receptionist;

import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Doctor;
import bd.edu.seu.hms.Service.DoctorService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewDoctorController implements Initializable {

    @FXML
    public TableColumn<Doctor, Number> feeCol;

    @FXML
    public TableColumn<Doctor, String> idCol;

    @FXML
    public TableColumn<Doctor, String> nameCol;

    @FXML
    public TableColumn<Doctor, String> phoneCol;

    @FXML
    public TableColumn<Doctor, String> qualificationCol;

    @FXML
    public TableColumn<Doctor, String> roomCol;

    @FXML
    public TableColumn<Doctor, String> specializationCol;

    @FXML
    public TableView<Doctor> doctorTable;

    private ObservableList<Doctor> doctorObservableList;


    @FXML
    public void close() {
        HelloApplication.sceneChange("homepage_receptionist");
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
    }
}
