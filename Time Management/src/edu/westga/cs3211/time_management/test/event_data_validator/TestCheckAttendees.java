package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestCheckAttendees {

	@Test
	void testAttendeesIsNull() {
		boolean result = EventDataValidator.checkAttendees(null);
		
		assertFalse(result);
	}

	@Test
	void testAttendeesIsEmpty() {
		List<String> attendees = List.of();
		
		boolean result = EventDataValidator.checkAttendees(attendees);
		
		assertTrue(result);
	}

	@Test
	void testAttendeesHasOneValidName() {
		List<String> attendees = List.of("Bob");
		
		boolean result = EventDataValidator.checkAttendees(attendees);
		
		assertTrue(result);
	}

	@Test
	void testAttendeesHasOneInvalidName() {
		List<String> attendees = List.of("");
		
		boolean result = EventDataValidator.checkAttendees(attendees);
		
		assertFalse(result);
	}

	@Test
	void testAttendeesHasMultipleNamesAllValid() {
		List<String> attendees = List.of("Bob", "Alice", "Trudy");
		
		boolean result = EventDataValidator.checkAttendees(attendees);
		
		assertTrue(result);
	}

	@Test
	void testAttendeesHasMultipleNamesSomeValidSomeInvalid() {
		List<String> attendees = List.of("Bob", "", "Trudy");
		
		boolean result = EventDataValidator.checkAttendees(attendees);
		
		assertFalse(result);
	}

	@Test
	void testAttendeesHasMultipleNamesAllInvalid() {
		List<String> attendees = List.of("", "", "");
		
		boolean result = EventDataValidator.checkAttendees(attendees);
		
		assertFalse(result);
	}

}
