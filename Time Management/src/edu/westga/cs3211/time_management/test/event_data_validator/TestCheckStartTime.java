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
class TestCheckStartTime {

	@Test
	void testNullStartTime() {
		boolean result = EventDataValidator.checkStartTime(null);
		
		assertFalse(result);
	}
	
	@Test
	void testStartTimeBeforeCurrentTime() {
		LocalDateTime timeBeforeNow = LocalDateTime.now().minusMinutes(10);
		
		boolean result = EventDataValidator.checkStartTime(timeBeforeNow);
		
		assertFalse(result);
	}

	@Test
	void testStartTimeAtCurrentTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		
		boolean result = EventDataValidator.checkStartTime(currentTime);
		
		assertTrue(result);
	}
	
	@Test
	void testStartTimeAfterCurrentTime() {
		LocalDateTime timeAfterNow = LocalDateTime.now().plusMinutes(10);
		
		boolean result = EventDataValidator.checkStartTime(timeAfterNow);
		
		assertTrue(result);
	}
	
}
