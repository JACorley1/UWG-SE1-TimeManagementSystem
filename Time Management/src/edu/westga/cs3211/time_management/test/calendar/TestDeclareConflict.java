package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestDeclareConflict {

	@Test
	void testEventIsNull() {
		Calendar calendar = new Calendar();
		
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							calendar.declareConflicts(null);
						}
					);
	}

	@Test
	void testNoEventsInCalendar() {
		Calendar calendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(100);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		Event event = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		
		List<Event> result = calendar.declareConflicts(event);
		
		assertEquals(0, result.size(), "checking number of conflicts");
	}
	
	@Test
	void testOneEventInCalendarEventIsBeforeCalendarEvent() {
		Calendar calendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(100);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		Event event1 = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		calendar.addEvent(event1);
		
		Event event = new Event("Bob", start.minusDays(3), end.minusDays(3), "location", "description", attendees, Visibility.PUBLIC);
		
		List<Event> result = calendar.declareConflicts(event);
		
		assertEquals(0, result.size(), "checking number of conflicts");
	}
	
	@Test
	void testOneEventInCalendarEventIsAfterCalendarEvent() {
		Calendar calendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(100);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		Event event1 = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		calendar.addEvent(event1);
		
		Event event = new Event("Bob", start.plusDays(3), end.plusDays(3), "location", "description", attendees, Visibility.PUBLIC);
		
		List<Event> result = calendar.declareConflicts(event);
		
		assertEquals(0, result.size(), "checking number of conflicts");
	}
	
	@Test
	void testOneEventInCalendarEventEndTimeOverlapsCalendarEvent() {
		Calendar calendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(100);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		Event event1 = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		calendar.addEvent(event1);
		
		Event event = new Event("Bob", start.minusHours(1), end.minusHours(1), "location", "description", attendees, Visibility.PUBLIC);
		
		List<Event> result = calendar.declareConflicts(event);
		
		assertEquals(1, result.size(), "checking number of conflicts");
	}

	@Test
	void testOneEventInCalendarEventStartTimeOverlapsCalendarEvent() {
		Calendar calendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(100);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		Event event1 = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		calendar.addEvent(event1);
		
		Event event = new Event("Bob", start.plusHours(1), end.plusHours(1), "location", "description", attendees, Visibility.PUBLIC);
		
		List<Event> result = calendar.declareConflicts(event);
		
		assertEquals(1, result.size(), "checking number of conflicts");
	}

}
