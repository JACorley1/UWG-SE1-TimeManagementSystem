package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestingCheckEndTime {

	@Test
	void testValidEndtime() {
		EventDataValidator validator = new EventDataValidator();
		
		LocalTime startTime = LocalTime.parse("10:42");
		LocalTime endTime = LocalTime.parse("11:42");
		
		boolean result = validator.checkEndTime(startTime, endTime);
		
		assertTrue(result);
	}
	
	
	@Test
	void testInvalidEndtimeEarlierThanStartTime() {
		EventDataValidator validator = new EventDataValidator();
		
		LocalTime startTime = LocalTime.parse("10:42");
		LocalTime endTime = LocalTime.parse("09:42");
		
		boolean result = validator.checkEndTime(startTime, endTime);
		
		assertFalse(result);
	}
	
	@Test
	void testErrorNullStart() {
		EventDataValidator validator = new EventDataValidator();
		
		LocalTime startTime = null;
		LocalTime endTime = LocalTime.parse("11:42");
		
		assertThrows(IllegalArgumentException.class, () -> validator.checkEndTime(startTime, endTime));
	}
	
	@Test
	void testErrorNullEnd() {
		EventDataValidator validator = new EventDataValidator();
		
		LocalTime startTime = LocalTime.parse("11:42");
		LocalTime endTime = null;
		
		assertThrows(IllegalArgumentException.class, () -> validator.checkEndTime(startTime, endTime));
	}
	
	

}
