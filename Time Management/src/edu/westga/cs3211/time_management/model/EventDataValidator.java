package edu.westga.cs3211.time_management.model;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Validate Event information.
 * 
 * @author Dylan Knox, Kyle Riggs, Cody Graham, Tyler Wingfield, Jeremiah
 *         Liscum, Joseph Fuller, Jonathan Corley, Tristen Rivera, Tyler Scott,
 *         Dexter Tarver, Daniel Jeselnik, Dylan McCleskey, Justin Smith
 */

public class EventDataValidator {

	private static final String START_TIME_NULL = "startTime cannot be null";
	
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
	 * Checks the start time, determining if it is before the current system time.
	 * This is used when displaying user warning when creating events startng in the past.
	 * 
	 * @param startTime the starting time of the event
	 * 
	 * @precondition startTime != null
	 * @throws NullPointerException if startTime is null
	 * 
	 * @return true if the start time is before the current time, false otherwise.
	 */
	public boolean isStartTimeBeforeNow(LocalDateTime startTime) {
		// TODO Note that the method was changed from checkStartTime() to isStartTimeBeforeNow() to better show intent and what the method is returning (boolean instead of void).
		if (startTime == null) {
			throw new NullPointerException(START_TIME_NULL);
		}
		
		return startTime.isBefore(LocalDateTime.now());
	}
	
	/**
	 * @authors TylerWingfield, JeremiahLiscum, JosephFuller
	 * @param endTime, startTime
	 * 
	 * @precondition startTime != null && endTime != null
	 * 
	 * @return boolean
	 */
	public boolean checkEndTime(LocalTime startTime, LocalTime endTime) {
		if(startTime==null) {
			throw new IllegalArgumentException("startTime cannot be null");
		}
		if(endTime==null) {
			throw new IllegalArgumentException("endTime cannot be null");
		}
		return endTime.compareTo(startTime)>0;
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
