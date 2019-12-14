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
	/**
	 * A Jframe used for showing error messages during room management.
	 */
	private JFrame jf = new JFrame();
	
	//TESTER METHOD DELETE LATER
	public Theater(Room rm) {
		name = "DEFAULT_THEATER_NAME";
		address = "DEFAULT_THEATER_ADDRESS";
		phoneNumber = "555-0000";
		roomList.add(rm);
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
		SeatCreator sc = new SeatCreator(roomList);
		sc.init();
	}
	
	//TEST CLASS RENAME LATER
	public void addRoomV2() {
		SeatCreatorV2 sc = new SeatCreatorV2(roomList);
		sc.init();
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
		try {
			if (roomList.isEmpty()) {
				throw new NullPointerException();
			}
			MovieCreator mc = new MovieCreator(roomList.get(roomList.size() - 1));
			mc.init();
		}
		catch (NullPointerException d) {
			d.getMessage();
			System.out.println("Error. No rooms in theater");
			JOptionPane.showMessageDialog(jf, "There is no rooms in the theater. Please add one before assigning a movie.");
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
