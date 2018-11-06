package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestCheckName {

	@Test
	void testCheckNameNull() {
		boolean result = EventDataValidator.checkName(null);
		
		assertFalse(result);
	}

	@Test
	void testCheckNameEmpty() {
		boolean result = EventDataValidator.checkName("");
		
		assertFalse(result);
	}
	
	
	@Test
	void testCheckName59Chars() {
		boolean result = EventDataValidator.checkName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg");
		
		assertTrue(result);
	}
	
	@Test
	void testCheckName60Chars() {
		boolean result = EventDataValidator.checkName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh");
		
		assertFalse(result);
	}
	
	
	@Test
	void testCheckName61Chars() {
		boolean result = EventDataValidator.checkName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghi");
		
		assertFalse(result);
	}
	
	
	@Test
	void testCheckNameCharsAndNumbers() {
		boolean result = EventDataValidator.checkName("abcdefg123456789");
		
		assertTrue(result);
	}

}
