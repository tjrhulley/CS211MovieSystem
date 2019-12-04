
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
	
	//MIGHT REPLACE WITH toggleTaken. LEAVING THIS HERE
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	public void toggleTaken() {
		if(isTaken) {
			isTaken = false;
		} else {
			isTaken = true;
		}
		return;
	}
	
	public boolean isTaken() {
		return isTaken;
	}
	
	public void toggleDisabled() {
		if(isDisabled) {
			isDisabled = false;
		} else {
			isDisabled = true;
		}
		return;
	}
	
	public boolean isDisabled() {
		return isDisabled;
	}
	
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
