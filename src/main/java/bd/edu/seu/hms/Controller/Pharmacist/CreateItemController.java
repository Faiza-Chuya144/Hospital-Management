package bd.edu.seu.hms.Controller.Pharmacist;
import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Item;
import bd.edu.seu.hms.Service.ItemService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;


public class CreateItemController implements Initializable {

    @FXML
    public TextField buyField;

    @FXML
    public TextArea descriptionField;

    @FXML
    public TextField idField;

    @FXML
    public ImageView imageField;

    @FXML
    public ToggleGroup itemToggle;

    @FXML
    public TextField nameField;

    @FXML
    public Spinner<Integer> quantityField;

    @FXML
    public TextField sellField;
    String imagePath;

    @FXML
    void save() {
        String id = idField.getText();
        String name = nameField.getText();
        String description = descriptionField.getText();
        double sellPrice = Double.parseDouble(sellField.getText());
        double buyPrice = Double.parseDouble(buyField.getText());
        int quantity =quantityField.getValue();

        RadioButton statusRadio = (RadioButton) itemToggle.getSelectedToggle();
        String status = statusRadio.getText();

        String imagePath = this.imagePath;



        ItemService itemService = new ItemService();
        Item item = new Item(id, name, description, sellPrice, buyPrice, quantity, status, imagePath);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        itemService.save(item);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Medicine Item saved successfully.");
        alert.showAndWait();

    }

    @FXML
    void close() {
        HelloApplication.sceneChange("homepage_pharmacist");
    }



    public void upload() throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Image img = new Image(file.toURI().toURL().toExternalForm());
            this.imagePath = file.toURI().toURL().toExternalForm();
            this.imageField.setImage(img);
        } else {
            System.out.println("no file has been selected!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quantityField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 0));
    }
}


