
public class Room {
	private String name;
	private Seat [][] seatList;
	//private ArrayList<Showing> showingList = new ArrayList<Showing>();
	
	public Room (String name, Seat[][] seatList) {
		this.name = name;
		this.seatList = seatList;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSeatList(Seat[][] seatList) {
		this.seatList = seatList;
	}
	
	public String getName() {
		return name;
	}
	
	public Seat[][] getSeatList() {
		return seatList;
	}
	
	public String toString() {
		String str = "Seating arrangements for " + name + "\n";
		
		for (int i = 0; i < seatList.length; i++) {
			str += "Row " + (i + 1) + " :";
			
			for (int j = 0; j < seatList[i].length; j++) {
				str += " " + seatList[i][j].toString();
			}
			
			str += "\n";
		}
		
		return str;
	}
}
