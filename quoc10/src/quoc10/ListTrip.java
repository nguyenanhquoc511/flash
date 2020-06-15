package quoc10;

public class ListTrip {
	private trip[] trip = new trip[100];
	private int countTrip;
	private double sumCity, sumSuburban;
	
	public void listTrip() {
		countTrip = 0;
		for(int i = 0; i < 100; i++) {
			trip[i] = new trip();
		}
	}
	
	public void inputTrip(int choose) {
		if (countTrip > 100)
			System.out.println("Not enough empty! ");
		else {
			if(choose == 1) {
				trip[countTrip] = new CityTrip();
				CityTrip city = new CityTrip();
				city.input();
				trip[countTrip] = city;
				sumCity += city.getRevenue();
			}
			else {
				trip[countTrip] = new SuburbanTrip();
				SuburbanTrip suburban = new SuburbanTrip();
				suburban.input();
				trip[countTrip] = suburban;
				sumSuburban += suburban.getRevenue();
			}
				
		}
		countTrip++;
	}
	
	public void showInfo() {
		for(int i = 0; i < countTrip; i++) {
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println(trip[i].toString());
		}
			System.out.println("----------------------------------------Reveneue----------------------------------------------");
			System.out.println("City Trip: "+ sumCity);
			System.out.println("Suburban Trip: "+ sumSuburban);
		
	}
}
