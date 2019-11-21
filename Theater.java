import java.util.ArrayList;

public class Theater {
	private String name;
	private String address;
	private String phoneNumber;
	//Prices?
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private ArrayList<Booking> bookingList = new ArrayList<Booking>();
	
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
		roomList.add(new Room());
	}
	
	//Copys the layout of one room and puts it into a new one
	//Will need to read every room from the one that is being copied, and then make new rooms in it with the same layout
	public void copyRoom(Room room) {
		
	}
	
	public void deleteRoom(int room) {
		roomList.remove(room);
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
	
	//End dump
	
	public String toString() {
		return "FILL ME IN!";
	}
}
