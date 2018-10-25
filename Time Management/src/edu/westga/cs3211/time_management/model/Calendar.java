package edu.westga.cs3211.time_management.model;

import java.util.ArrayList;

/** Store and manage a collection of events.
 * 
 * @author  jcorley, Victoria Jenkins, Laura Smedley, Jonathan Nicholl, Brandon Walker
 */
public class Calendar {


	private ArrayList<Event> events;
	
	public Calendar() {
		this.events = new ArrayList<Event>();
	}
	public boolean declareConflict(Event event) {
		for(Event current: this.events) {
			if(event.getStartTime.isAfter(current.getStartTime) && event.getStartTime.isBefore(current.getEndTime)) {
				return true;
			}
			if(event.getEndTime.isAfter(current.getStartTime) && event.getEndTime.isBefore(current.getEndTime)) {
				return true;
			}
		}
		
		return false;
	}
}
