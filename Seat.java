/**
 * A class representing a seat in a movie theater's room.
 * @author Timothy Hulley
 *
 */
public class Seat {
	/**
	 * The name of the seat.
	 */
	private String name;
	
	/**
	 * Boolean that states whether the seat is taken or not
	 */
	private boolean isTaken = false;
	
	/**
	 *  Boolean that states whether the seat is for people with disabilities.
	 */
	private boolean isDisabled;
	
	public Seat(String name, boolean isDisabled) {
		this.name = name;
		this.isDisabled = isDisabled;
	}
	
	/**
	 * Returns the seat's name.
	 * @return The seat's name.
	 */
	public String getName() {
		return name;
	}
	
	//MIGHT REPLACE WITH toggleTaken. LEAVING THIS HERE
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	/**
	 * Toggles between whether the seat is taken or not.
	 */
	public void toggleTaken() {
		if(isTaken) {
			isTaken = false;
		} else {
			isTaken = true;
		}
		return;
	}
	
	/**
	 * Checks if the seat is taken.
	 * @return True if it is taken.
	 */
	public boolean isTaken() {
		return isTaken;
	}
	
	/**
	 * Toggles between whether or not the seat is for people with disabilities.
	 */
	public void toggleDisabled() {
		if(isDisabled) {
			isDisabled = false;
		} else {
			isDisabled = true;
		}
		return;
	}
	
	/**
	 * Checks if the seat is for people with disabilities.
	 * @return True if it is.
	 */
	public boolean isDisabled() {
		return isDisabled;
	}
	
	/**
	 * String representation of the seat. It will display square brackets if it's regular, and curly brackets if it's disabled seating.
	 * If the seat is taken, an X will be displayed in the middle.
	 */
	public String toString() {
		String str = "";
		
		if (isDisabled) {
			str = "{ }";
		} else {
			str = "[ ]";
		}
		
		if (isTaken) {
			str = str.replace(" ", "X"); //Maybe str = str.replace?
		}
		
		return str;
	}
}