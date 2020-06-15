package quoc7;
import java.util.*;
public class studentList {
	void inputList(student[] list, int number) {
		String tmp;
		int id;
		long phone;
		Scanner objSc = new Scanner(System.in);
		
		for(int i = 0; i < number; i++) {
			
			list[i] = new student();
			System.out.println();
			System.out.println("Input Student's Information "+(i+1));
			
			do{
				System.out.print("Input ID: ");
				id = objSc.nextInt();
				if(!list[i].setId(id)) 
					System.out.println("Id not avalable, try again! ");
			} while(!list[i].setId(id));
			
			do{
				System.out.print("Input Name: ");
				objSc.nextLine();
				tmp = objSc.nextLine();
				if(!list[i].setName(tmp)) 
					System.out.println("Name not avalable, try again! ");
			} while(!list[i].setName(tmp));
			
			do{
				System.out.print("Input Address: ");
			//	objSc.nextLine();
				tmp = objSc.nextLine();
				if(!list[i].setAddress(tmp)) 
					System.out.println("Address not avalable, try again! ");
			} while(!list[i].setAddress(tmp));
			
			do{
				System.out.print("Input Phone: ");
				phone = objSc.nextLong();
				if(!list[i].setPhone(phone)) 
					System.out.println("Phone not avalable, try again! ");
			} while(!list[i].setPhone(phone));
		}
		
	}
	
	void outputList(student[] list, int number) {
		for(int i = 0; i < number; i++)
			System.out.println(list[i].toString());
	}
}
