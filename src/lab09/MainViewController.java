/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lab09;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author tanal
 */
public class MainViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private MenuItem closeItem;

    @FXML
    private MenuItem copyItem;

    @FXML
    private MenuItem findItem;

    @FXML
    private CheckMenuItem gridItem;

    @FXML
    private RadioMenuItem largeItem;

    @FXML
    private RadioMenuItem mediumItem;

    @FXML
    private MenuItem newItem;

    @FXML
    private MenuItem openItem;

    @FXML
    private MenuItem replaceItem;

    @FXML
    private MenuItem saveItem;

    @FXML
    private Menu searchMenu;

    @FXML
    private RadioMenuItem smallItem;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        smallItem.setToggleGroup(tg);
        mediumItem.setToggleGroup(tg);
        largeItem.setToggleGroup(tg);
        
        closeItem.setDisable(true); 
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
    
        ContextMenu popup = new ContextMenu();
        MenuItem help = new MenuItem("Help");
        MenuItem inspect = new MenuItem("Inspect");
        popup.getItems().addAll(help, inspect);
        mainPane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                popup.show(mainPane, e.getScreenX() - 50, e.getScreenY() - 25);
            }
        });

    }  
    
    @FXML
    void handleClose(ActionEvent event) {
        System.out.println("CLose has been pressed");
        newItem.setDisable(false);
        openItem.setDisable(false);
        closeItem.setDisable(true);
    }

    @FXML
    void handleCopy(ActionEvent event) {
        System.out.println("Copy pressed");
    }

    @FXML
    void handleFind(ActionEvent event) {
        System.out.println("Find pressed");
    }

    @FXML
    void handleGrid(ActionEvent event) {
        if (gridItem.isSelected()) {
            System.out.println("USE GRIDLINES selected");
        } else {
            System.out.println("USE GRIDLINES unselected");
        }
    }

    @FXML
    void handleNew(ActionEvent event) {
        System.out.println("NEW has been pressed");
        newItem.setDisable(true);
        openItem.setDisable(true);
        closeItem.setDisable(false);
    }

    @FXML
    void handleOpen(ActionEvent event) {
        System.out.println("Open pressed");
    }

    @FXML
    void handleReplace(ActionEvent event) {
        System.out.println("Replace pressed");
    }

    @FXML
    void handleSizeLarge(ActionEvent event) {
        if (largeItem.isSelected()) {
            System.out.println("Large size selected");
        }
    }

    @FXML
    void handleSizeMedium(ActionEvent event) {
        if (mediumItem.isSelected()) {
            System.out.println("Medium size selected");
        }
    }

    @FXML
    void handleSizeSmall(ActionEvent event) {
        if (smallItem.isSelected()) {
            System.out.println("Small size selected");
        }
    }
}
