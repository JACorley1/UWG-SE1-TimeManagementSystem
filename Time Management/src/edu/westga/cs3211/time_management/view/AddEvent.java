package edu.westga.cs3211.time_management.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.EventDataValidator;
import edu.westga.cs3211.time_management.model.Visibility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    
	private Calendar calendar;

    private void displayErrorMessage(String errorMessage) {
		Alert alert = new Alert(AlertType.ERROR, errorMessage);
		alert.showAndWait();
    }
    
    @FXML
    void addAttendee(ActionEvent event) {
    	String name = this.newAttendeeText.getText();
		if(EventDataValidator.checkName(name)) {
    		this.attendeesList.getItems().add(name);
    	}
		else {
			this.displayErrorMessage("Invalid name for new attendee: " + name);
		}
    }

    @FXML
    void removeAttendee(ActionEvent event) {
    	String name = this.attendeesList.getValue();
    	this.attendeesList.getItems().remove(name);
    }

    @FXML
    void cancel(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void addEvent(ActionEvent event) {
    	String errorText = "";
    	String name = this.nameText.getText();
    	if(!EventDataValidator.checkName(name)) {
    		errorText += "Name is invalid" + System.lineSeparator();
    	}
    	LocalDateTime startTime = LocalDateTime.of(this.startTimeDate.getValue(), LocalTime.of(9, 0));
    	LocalDateTime endTime = LocalDateTime.of(this.endTimeDate.getValue(), LocalTime.of(5, 0));
    	if(!EventDataValidator.checkStartTime(startTime)) {
    		errorText += "Start time is invalid" + System.lineSeparator();
    	}
    	else if(!EventDataValidator.checkStartTime(endTime)) {
    		errorText += "Start time is invalid" + System.lineSeparator();
    	}
    	List<String> attendees = this.attendeesList.getItems();
    	if(!EventDataValidator.checkAttendees(attendees)) {
    		errorText += "List of attendee names is invalid" + System.lineSeparator();
    	}
    	if(!errorText.isEmpty()) {
    		this.displayErrorMessage(errorText);
    		return;
    	}
    	
    	String location = this.locationText.getText();
    	if(location == null) {
    		location = "";
    	}
    	String description = this.descriptionText.getText();
    	if(description == null) {
    		description = "";
    	}
    	Visibility visibility = this.visibilityList.getValue();
    	
    	Event newEvent = new Event(name, startTime, endTime, location, description, attendees, visibility);
    	
    	List<Event> conflictingEvents = this.calendar.declareConflicts(newEvent);
    	
    	String eventText = newEvent.toStringFull();
    	String conflictText = "";
    	for(Event currEvent : conflictingEvents) {
    		conflictText += currEvent.toString() + System.lineSeparator();
    	}
    	String eventSummaryAndConflictText = "NEW EVENT DETAILS" + System.lineSeparator() + eventText + System.lineSeparator() + "CONFLICTING EVENTS" + conflictText;
		Alert alert = new Alert(AlertType.CONFIRMATION, eventSummaryAndConflictText);
		alert.setTitle("Create New Event?");
		
		Optional<ButtonType> result = alert.showAndWait();
		
		 if (result.isPresent() && result.get() == ButtonType.OK) {
			this.calendar.addEvent(newEvent);
			((Node)(event.getSource())).getScene().getWindow().hide();
		}
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

        this.attendeesList.setItems(FXCollections.observableArrayList());
        this.visibilityList.setItems(FXCollections.observableArrayList());
        this.visibilityList.getItems().add(Visibility.PUBLIC);
        this.visibilityList.getItems().add(Visibility.PRIVATE);
        this.visibilityList.getItems().add(Visibility.FRIENDS_ONLY);
        this.visibilityList.setValue(Visibility.PUBLIC);
        this.startTimeDate.setValue(LocalDate.now());
        this.endTimeDate.setValue(LocalDate.now());
    }

	public void setCalendar(Calendar calendar) {
		if(calendar == null) {
			throw new IllegalArgumentException("Calendar provided was null");
		}
		this.calendar = calendar;
	}
}
