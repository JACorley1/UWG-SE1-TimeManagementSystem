package edu.westga.cs3211.time_management.test.event;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestConstructor {

	@Test
	void testInvalidName() {	
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event(null, start, end, "", "", attendees, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testInvalidStartTime() {		
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", null, end, "", "", attendees, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testInvalidEndTime() {		
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		List<String> attendees = List.of();
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, null, "", "", attendees, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testInvalidAttendees() {		
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, "", "", null, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testNullLocation() {		
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, null, "", attendees, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testNullDescription() {		
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, "", null, attendees, Visibility.PUBLIC);
						}
					);
	}

	@Test
	void testNullVisibility() {		
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
			
		assertThrows(
						IllegalArgumentException.class, 
						()->{
							new Event("Bob", start, end, "", "", attendees, null);
						}
					);
	}

	@Test
	void testValidEvent() {			
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		
		Event result = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		
		assertEquals("Bob", result.getName(), "checking name");
		assertEquals(start, result.getStartTime(), "checking start time");
		assertEquals(end, result.getEndTime(), "checking end time");
		assertEquals("location", result.getLocation(), "checking location");
		assertEquals("description", result.getDescription(), "checking description");
		assertEquals(attendees, result.getAttendees(), "checking attendees");
		assertEquals(Visibility.PUBLIC, result.getVisibility(), "checking visibility");
	}

}
