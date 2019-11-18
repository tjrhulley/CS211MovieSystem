import java.util.Scanner;

public class Room {
	private String name;
	private Seat [][] seatList;
	//private ArrayList<Showing> showingList = new ArrayList<Showing>();
	
	public Room (String name){
		
	}
	
	/*
	 * edit the code so that you pic the number of rows and columns by default, and then which rows have handicapped seats.
		it will then automatically generate the regular rows and then ask for the seat position of the handicapped seats and how many there are.
	 */
	
	public void RoomCreationConcept (Scanner scnr) {
		String input = "";
		while (input != "Y") {
			System.out.println("Welcome to the room creation system! Please enter the room name or number");
			Object nameCheck = scnr.next(); //Make sure it's taking in a generic
			if (nameCheck instanceof Number) { //Definitely didn't do generics right in this if statement
				name = "Room " + nameCheck;
			} else if (nameCheck instanceof String) {
				name = nameCheck.toString();
			} //REWRITE if statement so it makes more sense
		
		
			System.out.println("Name of the room is " + name + ". is this correct? Enter Y or N.");
			input = scnr.nextLine();
			if (input == "y") {
				input = "Y"; //Do this for any other possible outputs of Yes, or encapsulate it in another loop that loops back to this question if not answered correctly
			}
		}
		
		input = "";
		
		while (input != "Y") {
			System.out.println("How many rows of seats are in the room?");
			int rowNum = scnr.nextInt(); //Add exception handling to make sure what's being entered is an integer
			
			System.out.println("Does the room have the same number of seats in each row? Enter Y or N.");
			if (input == "Y") {
				System.out.println("How many seats are in each row?");
				int seatNum = scnr.nextInt();
				
				seatList = new Seat[rowNum][seatNum];
			} else if (input == "N") { //definitely need to rethink how the list is going to be initialized, as they might be able to add seats. Maybe row objects?
				for (int i = 0; i < rowNum; i++) {
					System.out.println("How many seats are in row " + (i + 1) + "?");
					
				}
			} else {
				//Go back to the previous thing because it fucked up somewhere
			}
			
			//Loop that fills seatList with several empty seat objects
			
			//Final thing that creates the seatList, displays it, and then varifies if it's correct. Entering "Y" exits the loop and finishes the creation
			System.out.println(this.toString());
			System.out.println("Is this correct? Enter Y or N.");
			
			if (input == "y") {
				input = "Y"; 
			}
		}
		
		System.out.println("Room saved as " + name);
	}
	
	public String getName() {
		return name;
	}
	
	public Seat[][] getSeatList() {
		return seatList;
	}
	
	public String toString() {
		String str = "Seating arrangements for " + name;
		
		for (int i = 0; i < seatList.length; i++) {
			str += "Row " + i + ":";
			
			for (int j = 0; j < seatList[i].length; j++) {
				if (seatList[i][j].isTaken()) {
					str += " [X]";
				} else {
					str += " [ ]";
				}
			}
			
			str += "\n";
		}
		
		return str;
	}
}
