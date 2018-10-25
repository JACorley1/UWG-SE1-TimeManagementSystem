package edu.westga.cs3211.time_management.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/** Store basic information for an event.
 * 
 * @author Lucas Carlson, Carson Bedrosian, Nolan Williams, Kevin Flynn, Jonathan Corley, Tristen Rivera, Tyler Scott, Dexter Tarver
 */
public class Event {
	
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String location;
	private String description;
	private ArrayList<String> attendees;
	private Visibility visibility;
	
	public Event(String name, LocalDateTime start, LocalDateTime end, String location, String description, ArrayList<String> attendees, Visibility visibility) {
		this.name = name;
		this.startTime = start;
		this.endTime = end;
		this.location = location;
		this.description = description;
		this.attendees = attendees;
		this.visibility = visibility;
	}

	public String getName() {
		return this.name;
	}

	public LocalDateTime getStartTime() {
		return this.startTime;
	}

	public LocalDateTime getEndTime() {
		return this.endTime;
	}

	public String getLocation() {
		return this.location;
	}

	public String getDescription() {
		return this.description;
	}

	public ArrayList<String> getAttendees() {
		return this.attendees;
	}

	public Visibility getVisibility() {
		return this.visibility;
	}

	
}
