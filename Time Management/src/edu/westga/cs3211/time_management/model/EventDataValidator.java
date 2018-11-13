package edu.westga.cs3211.time_management.model;

import java.util.List;
import java.time.LocalDateTime;

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
	public static boolean checkName(String name) {
		boolean result = true;
		if (name == null) {
			result = false;
		} else if (name.length() >= 60) {
			result = false;
		} else if (name.isEmpty()) {
			result = false;
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
	public static boolean checkStartTime(LocalDateTime startTime) {
		if (startTime == null) {
			return false;
		}
		
		return !startTime.isBefore(LocalDateTime.now());
	}
	
	/**
	 * @authors TylerWingfield, JeremiahLiscum, JosephFuller
	 * @param endTime, startTime
	 * 
	 * @precondition startTime != null
	 * 
	 * @return true  if endTime is a valid time after startTime
	 * 		   false if endTime is not or is not after startTime
	 */
	public static boolean checkEndTime(LocalDateTime startTime, LocalDateTime endTime) {
		if(startTime == null) {
			throw new IllegalArgumentException("startTime cannot be null");
		}
		if(endTime == null) {
			return false;
		}
		return endTime.isAfter(startTime);
	}

	/** Checks the list of attendees
	 * 
	 * @precondition none
	 * @postcondition none
	 * 					
	 * @param String names the names of the attendees
	 * 
	 * @return true  if list contains valid names (see checkName for more details)
	 * 		   false if list contains one or more invalid names (see checkName for more details)
	 */
	public static boolean checkAttendees(List<String> names) {
		if (names == null) {
			return false;
		}
		
		for(String name : names) {
			if(!EventDataValidator.checkName(name)) {
				return false;
			}
		}
		return true;
	}
}
