package quoc13;
import java.util.*;
public class deal {
	
	Scanner objSc = new Scanner(System.in);
	protected String id, day;
	protected float sqard;
	protected double unitPrice, price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public float getSqard() {
		return sqard;
	}
	public void setSqard(float sqard) {
		this.sqard = sqard;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	protected deal() {
		this.id = "";
		this.day = "";
		this.sqard = 0;
		this.unitPrice = 0;
		this.price = 0;
	}
	
	protected deal(String id, String day, float sqard, double unitPrice, double price) {
		this.id = id;
		this.day = day;
		this.sqard = sqard;
		this.unitPrice = unitPrice;
		this.price = price;
	}
	
	protected void input() {
		System.out.print("Input ID: ");
		this.id = objSc.nextLine();
		System.out.print("Input Day: ");
		this.day = objSc.nextLine();
		System.out.print("Input Sqard: ");
		this.sqard = objSc.nextFloat();
		System.out.print("Input Unit Price: ");
		this.unitPrice = objSc.nextDouble();
	}
	
	public String toString() {
		return "\nID: "+getId()+ "\nDay: "+getDay()+"\nSqard: "+String.valueOf(this.sqard)+"\nUnit Price: "+String.valueOf(this.unitPrice);
	}
}
