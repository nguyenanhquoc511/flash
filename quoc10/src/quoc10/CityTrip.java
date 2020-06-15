package quoc10;
import java.util.*;
public class CityTrip extends trip{
	
	private double KMTraveled;
	private String routeNumber;
	Scanner objSc = new Scanner(System.in);
	
	public double getKMTraveled() {
		return KMTraveled;
	}
	public void setKMTraveled(double kMTraveled) {
		KMTraveled = kMTraveled;
	}
	public String getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}
	
	public CityTrip() {
		super();
		this.KMTraveled = 0;
		this.routeNumber = "";
	}
	
	public CityTrip(String idTrip, String nameDriver, String idCar, double revenue, double KMTraveled, String routeNumber) {
		super(idTrip, nameDriver, idCar, revenue);
		this.KMTraveled = KMTraveled;
		this.routeNumber = routeNumber;
	}
	
	public void input() {
		super.input();
		System.out.print("Input Kilometer Traveled: ");
		this.KMTraveled = objSc.nextDouble();
		System.out.print("Input Route Number: ");
		objSc.nextLine();
		this.routeNumber = objSc.nextLine();
	}
	
	public String toString() {
		return "City Trip: "+super.toString()+"\t\tKilometer Traveled: "+String.valueOf(getKMTraveled())+"\t\tRoute Number: "+getRouteNumber();
	}
}
