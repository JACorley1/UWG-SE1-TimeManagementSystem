package edu.westga.cs3211.time_management;

import java.util.ArrayList;

public class Calendar {
	
	public ArrayList<Event> events;
	
	public Calendar() {
		this.events = new ArrayList<Event>();
	}

	public boolean addEvent(Event event) {
		if(event==null) {
			throw new IllegalArgumentException("YourMomGay");
		}
		return this.events.add(event);
	}
	
}
