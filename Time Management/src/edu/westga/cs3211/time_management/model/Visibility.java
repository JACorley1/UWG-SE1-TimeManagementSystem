package edu.westga.cs3211.time_management.model;

/** Represents the visibility level of an Event.
 * 
 * @author Jonathan Corley
 *
 */
public enum Visibility {
	FRIENDS_ONLY,
	PUBLIC,
	PRIVATE;
	
	/** Convert the Visibility to a String representation.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return String representation of the Visibility
	 */
	@Override
	public String toString() {
		if (this == FRIENDS_ONLY) {
			return "Friends Only";
		}
		else if (this == PUBLIC) {
			return "Public";
		}
		else {
			return "Private";
		}
	}
}
