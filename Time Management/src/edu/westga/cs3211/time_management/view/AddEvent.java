package edu.westga.cs3211.time_management.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs3211.time_management.model.Visibility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/** Codebehind for the AddEvent Scene.
 * 
 * @author Jonathan Corley
 */
public class AddEvent {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML private Label visibilityLabel;
    @FXML private Label locationLabel;
    @FXML private Label attendeesLabel;
    @FXML private Label endTimeLabel;
    @FXML private Label startTimeLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label nameLabel;
    @FXML private TextField locationText;
    @FXML private TextField descriptionText;
    @FXML private TextField nameText;
    @FXML private DatePicker startTimeDate;
    @FXML private DatePicker endTimeDate;
    @FXML private TextField newAttendeeText;
    @FXML private ComboBox<String> attendeesList;
    @FXML private ComboBox<Visibility> visibilityList;

    @FXML
    void addAttendee(ActionEvent event) {

    }

    @FXML
    void removeAttendee(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void addEvent(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert visibilityLabel != null : "fx:id=\"visibilityLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert locationText != null : "fx:id=\"locationText\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert startTimeDate != null : "fx:id=\"startTimeDate\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert locationLabel != null : "fx:id=\"locationLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert attendeesLabel != null : "fx:id=\"attendeesLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert descriptionText != null : "fx:id=\"descriptionText\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert endTimeDate != null : "fx:id=\"endTimeDate\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert newAttendeeText != null : "fx:id=\"newAttendeeText\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert endTimeLabel != null : "fx:id=\"endTimeLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert attendeesList != null : "fx:id=\"attendeesList\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert startTimeLabel != null : "fx:id=\"startTimeLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert visibilityList != null : "fx:id=\"visibilityList\" was not injected: check your FXML file 'AddEvent.fxml'.";
        assert nameLabel != null : "fx:id=\"nameLabel\" was not injected: check your FXML file 'AddEvent.fxml'.";

    }
}
