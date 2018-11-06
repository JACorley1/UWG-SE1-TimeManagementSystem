package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestCheckEndTime {

	@Test
	void testValidEndtime() {
		LocalTime startTime = LocalTime.of(10,42);
		LocalTime endTime = LocalTime.of(11,42);
		LocalDate date = LocalDate.of(1, 2, 3);
		LocalDateTime start = LocalDateTime.of(date, startTime);
		LocalDateTime end = LocalDateTime.of(date, endTime);
		
		boolean result = EventDataValidator.checkEndTime(start, end);
		
		assertTrue(result);
	}
	
	
	@Test
	void testInvalidEndtimeEarlierThanStartTime() {
		LocalTime startTime = LocalTime.parse("10:42");
		LocalTime endTime = LocalTime.parse("09:42");
		LocalDate date = LocalDate.of(1, 2, 3);
		LocalDateTime start = LocalDateTime.of(date, startTime);
		LocalDateTime end = LocalDateTime.of(date, endTime);
		
		boolean result = EventDataValidator.checkEndTime(start, end);
		
		assertFalse(result);
	}
	
	@Test
	void testErrorNullStart() {
		LocalTime endTime = LocalTime.parse("11:42");
		LocalDate date = LocalDate.of(1, 2, 3);
		LocalDateTime end = LocalDateTime.of(date, endTime);
		
		assertThrows(IllegalArgumentException.class, () -> EventDataValidator.checkEndTime(null, end));
	}
	
	@Test
	void testErrorNullEnd() {
		LocalTime startTime = LocalTime.parse("11:42");
		LocalDate date = LocalDate.of(1, 2, 3);
		LocalDateTime start = LocalDateTime.of(date, startTime);
		
		boolean result = EventDataValidator.checkEndTime(start, null);
		
		assertFalse(result);
	}
	
	

}
