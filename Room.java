import java.util.Scanner;

public class Room {
	private String name;
	private Seat [][] seatList;
	//private ArrayList<Showing> showingList = new ArrayList<Showing>();
	private Scanner scnr;
	
	public Room (String name){
		this.name = name;
		RoomCreationConcept();
	}
	
	public void RoomCreationConcept () {
		scnr = new Scanner(System.in);
		String input = "";
		while (input.compareTo("Y") != 0) {
			System.out.println("Welcome to the room creation system! Please enter the room name or number");
			Object nameCheck = scnr.next(); //Make sure it's taking in a generic
			if (nameCheck instanceof Number) { //Definitely didn't do generics right in this if statement
				name = "Room " + nameCheck;
			} else if (nameCheck instanceof String) {
				name = nameCheck.toString();
			} //REWRITE if statement so it makes more sense
		
		
			System.out.println("Name of the room is " + name + ". is this correct? Enter Y or N.");
			input = scnr.next();
			if (input == "y") {
				input = "Y"; //Do this for any other possible outputs of Yes, or encapsulate it in another loop that loops back to this question if not answered correctly
			}
		}
		
		input = "";
		
		while (input.compareTo("Y") != 0) {
			System.out.println("How many rows of seats are in the room?");
			int rowNum = scnr.nextInt(); //Add exception handling to make sure what's being entered is an integer
			System.out.println("How many seats are in each row?");
			int colNum = scnr.nextInt();
			System.out.println("Does the room contain any handicapped seating? Y or N?");
			input = scnr.next();
			if (input == "Y") {
				System.out.println("Please enter which rows require handicapped seating (from top to bottom)."); //Maybe use an args since you don't have the exact number of rows needed
				//Also make sure to check if the inputs are all numbers, and that none of the numbers entered are greater than the number of rows, else return an error
				String disNum = scnr.next();
				/*
				//try {
					for (int i = 0; i < args.length(); i++) {
						if(args[i].getType != Number || args[i] > roomArray.lenght()) {
							//throw some sort of error;
						}
					}
				//}
				*/
				
				
			}
			
			//Loop that fills seatList with several empty seat objects
			
			seatList = new Seat[rowNum][colNum];
			
			for (int i = 0; i < rowNum; i++) {
				/*
				if (the row has a handicapped spot as specified) {
					System.out.println("How many handicapped seats are in row " + (i + 1));
					int disNum = scnr.nextInt();
					for (int d = 1; d <= disNum; d++) {
						System.out.println("What is the position of Handicapped seat " + d + "? (from left to right);
						//Maybe have another args?
					}
				} else {*/
				for (int j = 0; j < colNum; j++) {
					//Seat name format should include theater name, room name, row number/letter, and column number
					seatList[i][j] = new Seat("Seat" + i + j,false);
				}
				System.out.println("Created row " + i);
			}
			
			//Final thing that creates the seatList, displays it, and then varifies if it's correct. Entering "Y" exits the loop and finishes the creation
			System.out.println(this.toString());
			System.out.println("Is this correct? Enter Y or N.");
			input = scnr.next();
			
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
	
/* OLD SYSTEM FOR CREATING SEATS WITH DIFFERENT NUMBER OF SEATS IN EACH ROW
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
	}*/
}
