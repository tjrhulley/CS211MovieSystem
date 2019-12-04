import javax.swing.JFrame;

public class Tester {
	public static void main(String args[]) {
		
		Seat test = new Seat("S1",false);
		test.toggleTaken();
		System.out.println(test.toString());
		test.toggleTaken();
		System.out.println(test.toString());
		test.toggleDisabled();
		System.out.println(test.toString());
		test.toggleTaken();
		System.out.println(test.toString());
		
		Theater rm = new Theater();
		rm.addRoom();
	}
}
