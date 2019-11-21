
public class Seat {
	private String name;
	private boolean isTaken = false;
	private boolean isDisabled;
	
	public Seat(String name, boolean isDisabled) {
		this.name = name;
		this.isDisabled = isDisabled;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isTaken() {
		return isTaken;
	}
	
	public String toString() {
		String str = "";
		
		if (isDisabled) {
			str = "{ }";
		} else {
			str = "[ ]";
		}
		
		if (isTaken) {
			str.replace(" ", "X"); //Maybe str = str.replace?
		}
		
		return str;
	}
}
