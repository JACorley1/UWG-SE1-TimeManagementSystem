package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestingCheckName {

	@Test
	void testCheckNameEmpty() {


		EventDataValidator validator = new EventDataValidator();
		
		
		boolean result = validator.checkName("");
		
		assertFalse(result);
	}
	
	
	@Test
	void testCheckName59Chars() {


		EventDataValidator validator = new EventDataValidator();
		
		
		boolean result = validator.checkName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg");
		
		assertTrue(result);
	}
	
	@Test
	void testCheckName60Chars() {


		EventDataValidator validator = new EventDataValidator();
		
		
		boolean result = validator.checkName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh");
		
		assertFalse(result);
	}
	
	
	@Test
	void testCheckName61Chars() {


		EventDataValidator validator = new EventDataValidator();
		
		
		boolean result = validator.checkName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghi");
		
		assertFalse(result);
	}
	
	
	@Test
	void testCheckNameCharsAndNumbers() {


		EventDataValidator validator = new EventDataValidator();
		
		boolean result = validator.checkName("abcdefg123456789");
		
		assertTrue(result);
	}

}
