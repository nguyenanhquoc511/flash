package quoc10;
import java.util.*;
public class Run {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		ListTrip listTrip = new ListTrip();

		int choose;
		
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add City Trip");
			System.out.println("2. Add Suburban Trip");
			System.out.println("3. Show Information Trip");
			System.out.print("Your choose: ");
			choose = objSc.nextInt();
			
			switch(choose) {
			case 1: listTrip.inputTrip(choose);
					break;
			case 2: listTrip.inputTrip(choose);
					break;
			case 3: listTrip.showInfo();
					break;
			}
			
			System.out.println();
		} while (choose != 0);
		System.out.println();
	}

}
