
public class Seat {
	private String name;
	private boolean isTaken = false;
	
	public Seat(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isTaken() {
		return isTaken;
	}
}
