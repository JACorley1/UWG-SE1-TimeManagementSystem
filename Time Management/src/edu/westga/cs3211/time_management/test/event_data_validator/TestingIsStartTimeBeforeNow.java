package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

/**
 * 
 * @author Cody Graham, Kyle Riggs, Dylan Knox
 *
 */
class TestingIsStartTimeBeforeNow {

	@Test
	void testNullStartTime() {
		var validator = new EventDataValidator();
		
		assertThrows(NullPointerException.class, () -> validator.isStartTimeBeforeNow(null));
	}
	
	@Test
	void testStartTimeBeforeCurrentTime() {
		var validator = new EventDataValidator();
		var timeBeforeNow = LocalDateTime.now().minusMinutes(10);
		
		assertTrue(validator.isStartTimeBeforeNow(timeBeforeNow));
	}

	@Test
	void testStartTimeAtCurrentTime() {
		var validator = new EventDataValidator();
		var currentTime = LocalDateTime.now();
		
		assertFalse(validator.isStartTimeBeforeNow(currentTime));
	}
	
	@Test
	void testStartTimeAfterCurrentTime() {
		var validator = new EventDataValidator();
		var timeAfterNow = LocalDateTime.now().plusMinutes(10);
		
		assertFalse(validator.isStartTimeBeforeNow(timeAfterNow));
	}
	
}
