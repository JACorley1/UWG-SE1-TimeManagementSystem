package edu.westga.cs3211.time_management.test.visibility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Visibility;

class TestToString {

	@Test
	void testPublic() {
		String result = Visibility.PUBLIC.toString();
		
		assertEquals("Public", result);
	}

	@Test
	void testPrivate() {
		String result = Visibility.PRIVATE.toString();
		
		assertEquals("Private", result);
	}

	@Test
	void testFriendsOnly() {
		String result = Visibility.FRIENDS_ONLY.toString();
		
		assertEquals("Friends Only", result);
	}

}
