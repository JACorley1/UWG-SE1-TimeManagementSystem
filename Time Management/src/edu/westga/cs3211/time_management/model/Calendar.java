package edu.westga.cs3211.time_management.model;

import java.util.ArrayList;

/** Store and manage a collection of events.
 * 
 * @author jcorley, Lucas Carlson, Carson Bedrosian, Nolan Williams, Kevin Flynn
 */
public class Calendar {
	
	private ArrayList<Event> events;
	
	public Calendar() {
		
	}
	
	public void addEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException("Event cannot be null");
		}
		
		this.events.add(event);
	}
	
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	

}
