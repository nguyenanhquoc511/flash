package quoc7;
import java.util.*;
public class demo {

	public static void main(String[] args) {
		student[] listOfStu = new student[20];
		studentList list = new studentList();
		Scanner objSc = new Scanner(System.in);
		int number;
		
		System.out.print("Input Number Students: ");
		number = objSc.nextInt();
		
		list.inputList(listOfStu, number);
		list.outputList(listOfStu, number);
		
	}

}
