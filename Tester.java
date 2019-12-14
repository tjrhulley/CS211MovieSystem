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
				
		Theater th = new Theater();
		th.addRoomV2();
	}
}
