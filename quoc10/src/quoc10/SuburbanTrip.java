package quoc10;
import java.util.*;
public class SuburbanTrip extends trip{
	private String destination;
	private int days;
	
	Scanner objSc = new Scanner(System.in);
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	public SuburbanTrip(){
		super();
		this.days = 0;
		this.destination = "";
	}
	
	public SuburbanTrip(String idTrip, String nameDriver, String idCar, double revenue, String destination, int days) {
		super(idTrip, nameDriver, idCar, revenue);
		this.days = days;
		this.destination = destination;
	}
	
	public void input() {
		super.input();
		System.out.print("Input Destination: ");
		this.destination = objSc.nextLine();
		System.out.print("Input Days: ");
		this.days = objSc.nextInt();
	}
	
	public String toString() {
		return "Suburban Trip: "+super.toString()+"\t\tDestination: "+getDestination()+"\t\tDays: "+String.valueOf(getDays());
	}
}
