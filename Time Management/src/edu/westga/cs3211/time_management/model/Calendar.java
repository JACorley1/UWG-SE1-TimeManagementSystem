package edu.westga.cs3211.time_management.model;

import java.util.ArrayList;

/** Store and manage a collection of events.
 * 
 * @author Victoria Jenkins, Laura Smedley, Jonathan Nicholl, Brandon Walker
 */
public class Calendar {


	private ArrayList<Event> events;
	
	public Calendar() {
		this.events = new ArrayList<Event>();
	}
	public void declareConflict() {
		
	}
}
