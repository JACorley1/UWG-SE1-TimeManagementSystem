package edu.westga.cs3211.time_management.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AddEvent {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameLabel;

    @FXML
    void initialize() {
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";

    }
}
