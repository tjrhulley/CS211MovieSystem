import javax.swing.JFrame;

public class Tester {
	public static void main(String args[]) {
		/*
		Room rm = new Room("Dave", new Seat[4][3], 12,4,3);
		
		Seat[][] sl = rm.getSeatList();
		sl[1] = new Seat[5];
		
		for (int i = 0; i < sl.length; i++) {
			for (int j = 0; j < sl[i].length; j++) {
				System.out.println(j);
				System.out.println(sl[i][j]);
			}
		}
		*/
		
		Room r1 = new Room("Room A", new Seat[4][3], 12,4,3);
		Room r2 = new Room("Room B", new Seat[4][3], 12,4,3);
		Movie m1 = new Movie("Fateful Findings", "The best movie ever", "3.99", 120, "5pm");
		Movie m2 = new Movie("Twisted Pair", "The best movie ever", "3.99", 120, "5pm");
		Movie m3 = new Movie("I am here....now", "The best movie ever", "3.99", 120, "5pm");
		
		Theater th = new Theater(r1,r2,m1,m2,m3);
		th.assignMovie();
	}
}
