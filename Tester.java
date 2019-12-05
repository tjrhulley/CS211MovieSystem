import javax.swing.JFrame;

public class Tester {
	public static void main(String args[]) {
		
		Seat[][] dave = new Seat[5][3];
		Room rm = new Room ("meh", dave, 10);
		Theater th = new Theater(rm);
		th.addMovie(rm);
	}
}
