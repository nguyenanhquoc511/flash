package quoc1;

import java.util.*;

public class Demo {

	public static void main(String[] args) {
		
		birthday bd = new birthday();
		bd.input();
		System.out.println("Your Birthday: "+bd.day+"/"+bd.month+"/"+bd.year);
		System.out.println("Your Age: "+bd.calYearOld());

	}

}
