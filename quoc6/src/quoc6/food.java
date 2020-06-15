package quoc6;

import java.util.*;

public class food {
	
	private String id;
	public String name, dateOfMan, due;
	public double price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	food(String id, String name, double price, String dateOfMan, String due){
		setId(id);
		this.name = name;
		this.price = price;
		this.dateOfMan = dateOfMan;
		this.due = due;
	}
	
	food(String id){
		setId(id);
		this.price = 0;
		this.dateOfMan = "00/00/0000";
		this.due = "00/00/0000";
	}
	
	void input() {
	
}
