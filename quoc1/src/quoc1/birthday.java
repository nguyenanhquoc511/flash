package quoc1;
import java.util.*;
import java.util.Calendar;
public class birthday {
int day, month, year;
	
	birthday(){
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	
	birthday(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	void input() {
		Scanner objSc = new Scanner(System.in);
		int year,month,day;
		boolean check;
		
		do {
			System.out.print("Enter Year: ");
			year = objSc.nextInt();
			if (!(year >= 1900 && year <=2999))
				System.out.println("Invalid number of year. Try again!");
		} while(!(year >= 1900 && year <=2999));
		
		do {
			System.out.print("Enter Month: ");
			month = objSc.nextInt();
			if (!(month >= 1 && month <=12))
				System.out.println("Invalid number of month. Try again!");
		} while(!(month >= 1 && month <=12));
		
		do {
			check = true;
			System.out.print("Enter Day: ");
			day = objSc.nextInt();
			if(day > 31 || day < 1)			
				check = false;
			else 
				if ((day==31)&&(month == 2 || month == 4 || month == 6 || month == 9 || month == 11)) 
					check = false;
				else
					if ((day == 29 && year % 4 != 0 && month == 2)||(day == 30 && month == 2))
							check = false;
											
			if (check==false) System.out.println("Invalid number of day. Try again!");
				
		} while (check == false);
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	double calYearOld() {
		return (Calendar.getInstance().get(Calendar.YEAR) - year);
	}
}


	