package bd.edu.seu.hms.Controller.Pharmacist;

import bd.edu.seu.hms.Model.Item;
import bd.edu.seu.hms.Model.Payment;
import bd.edu.seu.hms.Model.Prescription;
import bd.edu.seu.hms.Model.Sales;
import bd.edu.seu.hms.Service.ItemService;
import bd.edu.seu.hms.Service.PaymentService;
import bd.edu.seu.hms.Service.SalesService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    public TableColumn<Sales, Number> quantityCol;

    @FXML
    public TextField balanceField;

    @FXML
    public TableColumn<Sales, String> medicineCodeCol;

    @FXML
    public TextField medicineCodeField;

    @FXML
    public TableColumn<Sales, String> medicineNameCol;

    @FXML
    public TextField medicineNameField;

    @FXML
    public TextField payField;

    @FXML
    public TableColumn<Sales, String> prescriptionNoCol;

    @FXML
    public TextField prescriptionNoField;

    @FXML
    public TableColumn<Sales, Number> priceCol;

    @FXML
    public Spinner<Integer> quantityField;

    @FXML
    public TableView<Sales> salesTable;

    @FXML
    public TextField totalCostField;

    @FXML
    public TableColumn<Sales, Number> totalPriceCol;
    @FXML
    public TextField PriceField;

    private Prescription selectedPrescription;
    private ObservableList<Sales> salesObservableList;
    public boolean isPrescriptionActive;

    @FXML
    public void setSelectedPrescription(Prescription prescription) {
        selectedPrescription = prescription;
        prescriptionNoField.setText(selectedPrescription.getPrescriptionNo());
        isPrescriptionActive = true;  // Start a new prescription
        calculateTotalCost();
    }

    @FXML
    void add() {
        String prescriptionNo = prescriptionNoField.getText();
        String medicineCode = medicineCodeField.getText();
        String medicineName = medicineNameField.getText();
        double price = Double.parseDouble(PriceField.getText());
        int quantity = quantityField.getValue();
        double totalPrice = price * quantity;

        Sales sales = new Sales(prescriptionNo, medicineCode, medicineName, price, quantity, totalPrice);
        SalesService salesService = new SalesService();
        if (salesService.add(sales)) {
            salesObservableList.add(sales);
            calculateTotalCost();
        }
    }

    @FXML
    void save() {
        double totalCost = Double.parseDouble(totalCostField.getText());
        double pay = Double.parseDouble(payField.getText());
        double balance = pay - totalCost;
        balanceField.setText(String.valueOf(balance));

        Payment payment = new Payment( totalCost, pay, balance);

        PaymentService paymentService = new PaymentService();
        paymentService.save(payment);

        isPrescriptionActive = false;
    }



    @FXML
    void close() {
        Stage stage = (Stage) prescriptionNoField.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prescriptionNoCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrescriptionNo()));
        medicineCodeCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMedicineCode()));
        medicineNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMedicineName()));
        priceCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getPrice()));
        quantityCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getQuantity()));
        totalPriceCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getTotalPrice()));

        salesObservableList = FXCollections.observableArrayList();
        SalesService salesService = new SalesService();
        salesObservableList.addAll(salesService.getSalesList());
        salesTable.setItems(salesObservableList);

        quantityField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));

        medicineCodeField.textProperty().addListener((observable, oldValue, newValue) -> medicineDetails(newValue));

    }

    private void medicineDetails(String medicineCode) {
        ItemService itemService = new ItemService();
        Item item = itemService.getItemByCode(medicineCode);
        if (item != null) {
            medicineNameField.setText(item.getName());
            PriceField.setText(String.valueOf(item.getSellPrice()));
        } else {
            medicineNameField.clear();
            PriceField.clear();
        }
    }

    private void calculateTotalCost() {
        double totalCost = salesObservableList.stream().filter(sales -> sales.getPrescriptionNo().equals(prescriptionNoField.getText())).mapToDouble(Sales::getTotalPrice).sum();
        totalCostField.setText(String.valueOf(totalCost));

    }
}
