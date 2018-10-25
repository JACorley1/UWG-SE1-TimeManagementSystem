package edu.westga.cs3211.time_management.model;

import java.util.List;
import java.time.LocalTime;

/**
 * Validate Event information.
 * 
 * @author Dylan Knox, Kyle Riggs, Cody Graham, Tyler Wingfield, Jeremiah
 *         Liscum, Joseph Fuller, Jonathan Corley, Tristen Rivera, Tyler Scott,
 *         Dexter Tarver, Daniel Jeselnik, Dylan McCleskey, Justin Smith
 */

public class EventDataValidator {

	/**
	 * Checks if the even name is valid
	 * 
	 * @precondition name must be < 60 characters and name cannot be empty
	 * @postcondition none
	 * 
	 * @param name the name of the event
	 * @return true if the name is valid
	 */
	public boolean checkName(String name) {

		boolean result;
		
		if(name.length() >= 60) {
			result = false;
		} else if (name.isEmpty()) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	
	/**
	 * @authors TylerWingfield, JeremiahLiscum, JosephFuller
	 * @param endTime
	 * @return
	 */
	public boolean checkEndTime(LocalTime startTime, LocalTime endTime) {
		return endTime.compareTo(startTime)>0;
	}

	/**
	 * Checks start time.
	 * 
	 */
	public void checkStartTime(LocalTime startTime) {

	}

	/**
	 * Checks the list of attendees
	 * 
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
