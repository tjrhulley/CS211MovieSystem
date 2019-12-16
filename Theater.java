import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A class representing the entire theater
 * @author Timothy Hulley
 *
 */
public class Theater {
	/**
	 * The name of the theater.
	 */
	private String name;
	/**
	 * The theater's street address.
	 */
	private String address;
	/**
	 * The theater's phone number.
	 */
	private String phoneNumber;
	/**
	 * A list of each room in the theater.
	 */
	private ArrayList<Room> roomList = new ArrayList<Room>();
	//added this -sara
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}

	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	/**
	 * A Jframe used for showing error messages during room management.
	 */
	private JFrame jf = new JFrame();
	
	//TESTER METHOD DELETE LATER
	public Theater(Room r1, Room r2, Movie m1, Movie m2, Movie m3) {
		name = "DEFAULT_THEATER_NAME";
		address = "DEFAULT_THEATER_ADDRESS";
		phoneNumber = "555-0000";
		roomList.add(r1);
		roomList.add(r2);
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
	}

	public Theater(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public Theater() {
		name = "DEFAULT_THEATER_NAME";
		address = "DEFAULT_THEATER_ADDRESS";
		phoneNumber = "555-0000";
	}
	
	/**
	 * Calls a new SeatCreator object to add a room to the theater's roomList
	 */
	public void addRoom() {
		int choice = JOptionPane.showConfirmDialog(null, "Does the room have the same number of seats in each row?", "Choose an option", JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			SeatCreator sc = new SeatCreator(roomList);
			sc.init();
		} else {
			SeatCreator sc = new SeatCreator(roomList);
			sc.init();
		}
	}
	
	/**
	 * Copies the layout of one room and puts it into a new one.
	 * @param room The room being copied.
	 */
	public void copyRoom(Room room) {
		roomList.add(new Room(room.getName(), room.getSeatList(), room.getNumSeats(), room.getNumRows(), room.getNumColumns()));
	}
	
	/**
	 * Deletes a room from the roomList.
	 * @param room The room to be deleted.
	 * @return True if the specified room is in roomList and was removed. False if the specified room was not found in roomList
	 */
	public boolean deleteRoom(Room room) {
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i) == room) {
				roomList.remove(i);
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * Calls a new MovieCreator object to add a movie to the theater's movie list.
	 * Will not work if the theater has no rooms.
	 */
	public void addMovie() {
		MovieCreator mc = new MovieCreator(movieList);
		mc.init();
	}
	
	public boolean deleteMovie(Movie movie) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i) == movie) {
				movieList.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public void assignMovie() {
		try {
			if (roomList.isEmpty() || movieList.isEmpty()) {
				throw new NullPointerException();
			}
			MovieAssigner ma = new MovieAssigner(roomList, movieList);
			ma.init();
		}
		catch (NullPointerException d) {
			d.getMessage();
			System.out.println("Error. No rooms in theater");
			JOptionPane.showMessageDialog(jf, "The theater needs to have at least one movie and room before it can assign them.");
			return;
		}
	}
	
	// Dump for setters and getters
	
	/**
	 * Sets the name of the theater
	 * @param name A String value representing the theater's new name
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * Sets the street address of the theater
	 * @param name A String value representing the theater's new address
	 */
	public void setAddress (String address) {
		this.address = address;
	}
	
	/**
	 * Sets the phone number of the theater
	 * @param name A String value representing the theater's new phone number
	 */
	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Returns the name of the theater
	 * @return name A String value representing the theater's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the street address of the theater
	 * @return name A String value representing the theater's address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Returns the phone number of the theater
	 * @return name A String value representing the theater's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Returns the list of rooms in the theater
	 * @return name An ArrayList representing the list of rooms
	 */
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	//End dump
	
	/**
	 * String representation of the theater. Displays each room and the seat arrangements of those rooms
	 */
	public String toString() {
		String str = "List of rooms in theater " + name + "\n\n";
		
		for (int i = 0; i < roomList.size(); i++) {
			str += roomList.get(i).toString();
			str += "\n";
		}
		
		return str;
	}
}