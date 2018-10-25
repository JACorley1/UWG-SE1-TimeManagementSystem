package edu.westga.cs3211.time_management.model;

import java.util.List;
import java.time.LocalTime;

/** Validate Event information.
 * 
 * @author 
 * @author Dylan Knox, Kyle Riggs, Cody Graham, Jonathan Corley, Daniel Jeselnik, Dylan McCleskey, Justin Smith
 */
public class EventDataValidator {

	/**
	 * Checks start time.
	 * 
	 */
	public void checkStartTime(LocalTime startTime) {
		
	}
	
	/**
	 * Checks the list of attendees
	 * @param String names
	 */
	public void checkAttendees(List<String> names) {
		if (names == null) {
			
		}
		List<String> attendees = names;
		for (String curAttendee : attendees) {
			
		}
	}
}
