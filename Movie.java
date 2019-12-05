
public class Movie {
	private String name;
	private String description;
	private String price;
	private int lengthInMins;
	private String showTime;
	
	public Movie (String name, String description, String price, int lengthInMins, String showTime) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.lengthInMins = lengthInMins;
		this.showTime = showTime;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String description) {
		this.description = description;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setLength(int lengthInMins) {
		this.lengthInMins = lengthInMins;
	}
	
	public void setShowTimes(String showTime) {
		this.showTime = showTime;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return description;
	}
	
	public String getPrice() {
		return price;
	}
	
	public int getLength() {
		return lengthInMins;
	}
	
	public String getShowTime() {
		return showTime;
	}
}
