package edu.westga.cs3211.time_management.model;

/** Validate Event information.
 * 
 * @author Tristen Rivera, Tyler Scott, Dexter Tarver
 */
public class EventDataValidator {
	
	/**Checks if the even name is valid
	 * 
	 * @precondition name must be < 60 characters and name cannot be empty
	 * @postcondition none
	 * 
	 * @param name the name of the event
	 * @return true if the name is valid
	 */
	public boolean checkName(String name) {
		
		boolean result;
		
		if(name.length() > 60) {
			result = false;
		}else if(name.isEmpty()) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}

}
