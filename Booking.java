public class Booking {
	protected String name;
	protected int ticket;
	protected int HTicket;
	public Booking (String name, int ticket, int HTicket) {
		this.name = name;
		this.ticket = ticket;
		this.HTicket = HTicket;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getTicket() {
		return this.ticket;
	}
	
	public int getHTicket() {
		return this.HTicket;
	}
	public String toString() {
		return ("Testing to check");
	}
}