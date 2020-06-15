package manager;

public class function {
	
	public boolean checkFomatDate(int[] arrIntDate) {

		if (arrIntDate.length != 3) {
			System.out.println("Fomat date available, try again!!");
			return false;
		}
		if (arrIntDate[0] > 31 || arrIntDate[0] < 1) {
			System.out.println("Day not available, try again!!");
			return false;
		}
		if (arrIntDate[1] > 12 || arrIntDate[1] < 1) {
			System.out.println("Month not available, try again!!");
			return false;
		}
		if (arrIntDate[2] > 2020 || arrIntDate[2] < 1800) {
			System.out.println("Year not available, try again!!");
			return false;
		}

		return true;

	}

	public boolean checkDate(String date) {
		// dd/mm/yyyy
		String[] dateSplit = date.split("/");
		int[] intSplit = new int[dateSplit.length];
		for (int i = 0; i < dateSplit.length; i++) {
			intSplit[i] = Integer.parseInt(dateSplit[i]);
		}

		if(!checkFomatDate(intSplit)) return false;

		return true;
	}
	
	public boolean checkId(items[] its, int count, String id) {
		for (int i = 0; i <= count - 1; i++)
			if (its[i].getId().equalsIgnoreCase(id)) {
				System.out.println("ID already exist, try again with another ID!!");
				return false;
			}
		return true;
	}
	
}
