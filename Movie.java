public class Movie {
	private String name;
	private String description;
	private String price;
	private int lengthInMins;
	private String showTime;
	private Room room;
	
	public Movie (String name, String description, String price, int lengthInMins, String showTime) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.lengthInMins = lengthInMins;
		this.showTime = showTime;
		//room = new Room("TEMP", new Seat[0][0], 0,0,0);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String description) {
		this.description = description;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setLength(int lengthInMins) {
		this.lengthInMins = lengthInMins;
	}
	
	public void setShowTimes(String showTime) {
		this.showTime = showTime;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return description;
	}
	
	public String getPrice() {
		return price;
	}
	
	public int getLength() {
		return lengthInMins;
	}
	
	public String getShowTime() {
		return showTime;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public String toString() {
		String str = "Movie name: " + name + "\n" + description + "\n";
		str += "Length:" + lengthInMins + " minutes \n";
		str += "Price: " + price + "\n";
		str += "Playing in room " + room.getName() + " at " + showTime + ". \n";
		return str;
	}
}