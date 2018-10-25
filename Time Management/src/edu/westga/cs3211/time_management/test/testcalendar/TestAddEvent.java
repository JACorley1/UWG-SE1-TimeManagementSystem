package edu.westga.cs3211.time_management.test.testcalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

public class TestAddEvent {

	@Test
	public void testAddNullEvent() {
		Calendar myCalendar = new  Calendar();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myCalendar.addEvent(null);
		});
		
	}
	
	@Test
	public void testAddOneEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start = LocalDateTime.now();
		LocalDateTime end = LocalDateTime.of(2018, 12, 2, 1, 1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent);
		
		Assertions.assertEquals(1, myCalendar.getEvents().size());
		
	}

}
