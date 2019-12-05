
public class Room {
	private String name;
	private Seat [][] seatList;
	private Movie movie;
	private int maxSeats;
	private int numSeats;
	private int numRows;
	private int numCols;
	
	public Room (String name, Seat[][] seatList, int seats, int numRows, int numCols) {
		this.name = name;
		this.seatList = seatList;
		this.maxSeats = seats;
		this.numSeats = seats;
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSeatList(Seat[][] seatList) {
		this.seatList = seatList;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public void addSeats() {
		if (numSeats > maxSeats) {
			System.out.println("Error. Maximum number of seats reached.");
			return;
		}
		
		numSeats++;
	}
	
	public void subtractSeats() {
		if (numSeats < 0) {
			System.out.println("Error. All seats have been taken.");
			return;
		}
		
		numSeats--;
	}
	
	public String getName() {
		return name;
	}
	
	public Seat[][] getSeatList() {
		return seatList;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public int getNumSeats() {
		return numSeats;
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numCols;
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
		
		str += "Movie currently showing is  " + movie + ". \n";
		str += "Number of available seats: " + numSeats + "\n";
		
		return str;
	}
}
