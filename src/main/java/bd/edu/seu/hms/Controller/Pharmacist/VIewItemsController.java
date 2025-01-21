/*package bd.edu.seu.hms.Controller.Pharmacist;
import bd.edu.seu.hms.Model.Item;
import bd.edu.seu.hms.Service.ItemService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class VIewItemsController implements Initializable {

    @FXML
    public TableColumn<Item, Number> buyCol;

    @FXML
    public Label buyFx;

    @FXML
    public TableColumn<Item, String> descriptionCol;

    @FXML
    public Label descriptionFx;

    @FXML
    public TableColumn<Item, String> idCol;

    @FXML
    public Label idFx;

    @FXML
    public ImageView imageFx;

    @FXML
    public TableView<Item> itemTable;

    @FXML
    public TableColumn<Item, String> nameCol;

    @FXML
    public Label nameFx;

    @FXML
    public TableColumn<Item, Number> quantityCol;

    @FXML
    public Label quantityFx;

    @FXML
    public TextField searchInput;

    @FXML
    public TableColumn<Item, Number> sellCol;

    @FXML
    public Label sellFx;

    @FXML
    public Label statusFx;
    private ObservableList<Item> itemObservableList;


    @FXML
    public void close() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        descriptionCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
        sellCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getSellPrice()));
        buyCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getBuyPrice()));
        quantityCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getQuantity()));

        itemObservableList = FXCollections.observableArrayList();
        ItemService itemService = new ItemService();
        itemObservableList.addAll(itemService.getItemList());
        itemTable.setItems(itemObservableList);

        searchInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    search();
                }
            }
        });
    }

    public void search() {
        String searchText = searchInput.getText().toLowerCase();
        ObservableList<Dress> searchResult = FXCollections.observableArrayList();
        for (Dress dress : read()) {
            if (dress.getName().toLowerCase().contains(searchText)) {
                searchResult.add(dress);
            }
        }
        dressListTableFX.setItems(searchResult);
    }
}*/

package bd.edu.seu.hms.Controller.Pharmacist;

import bd.edu.seu.hms.HelloApplication;
import bd.edu.seu.hms.Model.Item;
import bd.edu.seu.hms.Service.ItemService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class VIewItemsController implements Initializable {

    @FXML
    public TableColumn<Item, Number> buyCol;

    @FXML
    public Label buyFx;

    @FXML
    public TableColumn<Item, String> descriptionCol;

    @FXML
    public Label descriptionFx;

    @FXML
    public TableColumn<Item, String> idCol;

    @FXML
    public Label idFx;

    @FXML
    public ImageView imageFx;

    @FXML
    public TableView<Item> itemTable;

    @FXML
    public TableColumn<Item, String> nameCol;

    @FXML
    public Label nameFx;

    @FXML
    public TableColumn<Item, Number> quantityCol;

    @FXML
    public Label quantityFx;

    @FXML
    public TextField searchInput;

    @FXML
    public TableColumn<Item, Number> sellCol;

    @FXML
    public Label sellFx;

    @FXML
    public Label statusFx;

    private ObservableList<Item> itemObservableList;

    @FXML
    public void close() {
        HelloApplication.sceneChange("homepage_pharmacist");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        nameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        descriptionCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDescription()));
        sellCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getSellPrice()));
        buyCol.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getBuyPrice()));
        quantityCol.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getQuantity()));

        itemObservableList = FXCollections.observableArrayList();
        ItemService itemService = new ItemService();
        itemObservableList.addAll(itemService.getItemList());
        itemTable.setItems(itemObservableList);

        searchInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    search();
                }
            }
        });

        // Set listener for item selection to display details
        itemTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showItemDetails(newValue));
    }

    public void search() {
        String searchText = searchInput.getText().toLowerCase();
        ObservableList<Item> searchResult = FXCollections.observableArrayList();
        for (Item item : itemObservableList) {
            if (item.getName().toLowerCase().contains(searchText) || item.getId().toLowerCase().contains(searchText)) {
                searchResult.add(item);
            }
        }
        itemTable.setItems(searchResult);
    }

    private void showItemDetails(Item item) {
        if (item != null) {
            idFx.setText(item.getId());
            nameFx.setText(item.getName());
            descriptionFx.setText(item.getDescription());
            sellFx.setText(String.valueOf(item.getSellPrice()));
            buyFx.setText(String.valueOf(item.getBuyPrice()));
            quantityFx.setText(String.valueOf(item.getQuantity()));
            statusFx.setText(item.getStatus());

            // Load image if the path is valid
            if (item.getImagePath() != null && !item.getImagePath().isEmpty()) {
                try {
                    Image image = new Image(item.getImagePath());
                    imageFx.setImage(image);
                } catch (Exception e) {
                    System.out.println("Error loading image: " + e.getMessage());
                    imageFx.setImage(null);
                }
            } else {
                imageFx.setImage(null);
            }
        } else {
            idFx.setText("");
            nameFx.setText("");
            descriptionFx.setText("");
            sellFx.setText("");
            buyFx.setText("");
            quantityFx.setText("");
            statusFx.setText("");
            imageFx.setImage(null);
        }
    }
}

