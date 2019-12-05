import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Theater {
	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private JFrame jf = new JFrame();
	
	//TESTER METHOD DELETE LATER
	public Theater(Room rm) {
		name = "DEFAULT_THEATER_NAME";
		address = "DEFAULT_THEATER_ADDRESS";
		phoneNumber = "555-0000";
		roomList.add(rm);
	}
	
	//Maybe add a int application so that the number of rooms in it can be specified
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
	
	public void addRoom() {
		//Room objects are created and added individually
		SeatCreator sc = new SeatCreator(roomList);
		sc.init();
	}
	
	public void editRoom() {
		
	}
	
	//Copies the layout of one room and puts it into a new one
	//Will need to read every room from the one that is being copied, and then make new rooms in it with the same layout
	public void copyRoom(Room room) {
		roomList.add(new Room(room.getName(), room.getSeatList(), room.getNumSeats(), room.getNumRows(), room.getNumColumns()));
	}
	
	public boolean deleteRoom(Room room) {
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i) == room) {
				roomList.remove(i);
				return true;
			}
		}
		
		return false;
		
	}
	
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
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}
	
	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	
	//End dump
	
	public String toString() {
		String str = "List of rooms in theater " + name + "\n\n";
		
		for (int i = 0; i < roomList.size(); i++) {
			str += roomList.get(i).toString();
			str += "\n";
		}
		
		return str;
	}
}
