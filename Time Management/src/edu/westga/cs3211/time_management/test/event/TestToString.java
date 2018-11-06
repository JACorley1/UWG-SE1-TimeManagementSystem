package edu.westga.cs3211.time_management.test.event;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestToString {

	@Test
	void test() {
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		List<String> attendees = List.of();
		Event event = new Event("Bob", start, end, "location", "description", attendees, Visibility.PUBLIC);
		
		String result = event.toString();
		
		String expectedString = "Bob(" + start + "," + end + ")";
		assertEquals(expectedString, result);
		
	}

}
