package quoc17;

import java.util.*;

public class vehicleList {

	Scanner objSc = new Scanner(System.in);
	public int n;
	public vehicle[] arrayOfVehicle = new vehicle[n];

	public vehicleList() {

	}

	public void input() {
		int choose;
		System.out.println("how many vehicles in the list?");
		this.n = objSc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Choose vehicle type: \n1.Car: \n2.Bicycle: ");
			choose = objSc.nextInt();
			if (choose == 1) {
				System.out.println("Enter color respectively, speed, size of engine and number of doors:  ");
				arrayOfVehicle[i] = new car(objSc.nextLine(), objSc.nextInt(), objSc.nextInt(), objSc.nextInt());
			} else {
				System.out.println("Enter color respectively, speed, number of wheel:  ");
				arrayOfVehicle[i] = new bicycle(objSc.nextLine(), objSc.nextInt(), objSc.nextInt());
			}
		}

	}
	
	public void output() {
		for(int i = 0; i < n; i++)
			arrayOfVehicle[i].go();
	}

}
