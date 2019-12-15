/**
 * A class representing a room in a theater
 * @author Timothy Hulley
 *
 */
public class Room {
	/**
	 * The name of the room
	 */
	private String name;
	/**
	 * The seating arrangement of the room
	 */
	private Seat [][] seatList;
	/**
	 * The maximum number of available seats the room has
	 */
	private int maxSeats;
	/**
	 * The total number of available seats in the room.
	 * Cannot exceed maxSeats or be below 0
	 */
	private int numSeats;
	/**
	 * The number of rows of seats in the room
	 */
	private int numRows;
	/**
	 * The number of columns of seats in the room
	 */
	private int numCols;
	
	public Room (String name, Seat[][] seatList, int seats, int numRows, int numCols) {
		this.name = name;
		this.seatList = seatList;
		this.maxSeats = seats;
		this.numSeats = seats;
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	/**
	 * Sets the name of the room
	 * @param name A String representing the room's new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the seating arrangement of the room
	 * @param name A 2d array of Seat objects that represents the room's new seating arrangement
	 */
	public void setSeatList(Seat[][] seatList) {
		this.seatList = seatList;
	}
	
	/**
	 * Adds seats to numSeats whenever new seats are available. Returns an error if the max number of seats is reached.
	 */
	public void addSeats() {
		if (numSeats > maxSeats) {
			System.out.println("Error. Maximum number of seats reached.");
			return;
		}
		
		numSeats++;
	}
	
	/**
	 * Removes seats from numSeats whenever seats are taken. Returns an error if the max number of seats is reached.
	 */
	public void subtractSeats() {
		if (numSeats < 0) {
			System.out.println("Error. All seats have been taken.");
			return;
		}
		
		numSeats--;
	}
	
	/**
	 * Returns the name of the room.
	 * @return the name of the room.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the list of seats in the room.
	 * @return the list of seats in the room.
	 */
	public Seat[][] getSeatList() {
		return seatList;
	}
	
	/**
	 * Returns the number of available seats in the room.
	 * @return the number of available seats in the room.
	 */
	public int getNumSeats() {
		return numSeats;
	}
	
	/**
	 * Returns the number of seat rows in the room.
	 * @return the number of seat rows in the room.
	 */
	public int getNumRows() {
		return numRows;
	}
	
	/**
	 * Returns the number of seat columns in the room.
	 * @return the number of seat columns in the room.
	 */
	public int getNumColumns() {
		return numCols;
	}
	
	/**
	 * String representation of the room. Prints the seating arrangement, the movie currently playing, and the number of seats.
	 */
	public String toString() {
		String str = "Seating arrangements for " + name + "\n";
		
		for (int i = 0; i < seatList.length; i++) {
			str += "Row " + (i + 1) + " :";
			
			for (int j = 0; j < seatList[i].length; j++) {
				str += " " + seatList[i][j].toString();
			}
			
			str += "\n";
		}
		
		str += "Number of available seats: " + numSeats + "\n";
		
		return str;
	}
}
