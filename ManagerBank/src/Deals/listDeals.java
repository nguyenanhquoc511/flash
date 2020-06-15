package Deals;

public class listDeals {
	public int countDeals;
	public Deal[] listOfDeals = new Deal[100];

	public void initList() {
		countDeals = 0;
		for (int i = 0; i < 100; i++)
			listOfDeals[i] = new Deal();
	}

	public boolean addDeals(Deal d) {
		if (countDeals > 100) {
			System.out.println("Not enought Empty!!");
			return false;
		} else {
			listOfDeals[countDeals] = d;
			System.out.println("Add deal to list successful!!");
			countDeals++;
			return true;
		}
	}

	public void showList() {
		for (int i = countDeals - 1; i >= 0 ; i--) {
			System.out.println("\nInformation Deal " + (i + 1) + ": ");
			System.out.println(listOfDeals[i].toString());
		}
	}

	public void findByIdCustomer(long id) {
		boolean check = false;
		for (int i = countDeals - 1; i >= 0 ; i--)
			if (listOfDeals[i].idCustomer == id || listOfDeals[i].idReceive == id) {
				System.out.println(listOfDeals[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByIdDeals(long id) {
		boolean check = false;
		for (int i = countDeals - 1; i >= 0 ; i--)
			if (listOfDeals[i].idDeal == id) {
				System.out.println(listOfDeals[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByDate(String date) {
		boolean check = false;
		for (int i = countDeals - 1; i >= 0 ; i--)
			if (listOfDeals[i].date.equalsIgnoreCase(date)) {
				System.out.println(listOfDeals[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByLowMoney(double money) {
		boolean check = false;
		for (int i = countDeals - 1; i >= 0 ; i--)
			if (listOfDeals[i].money <= money) {
				System.out.println(listOfDeals[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

	public void findByHighMoney(double money) {
		boolean check = false;
		for (int i = countDeals - 1; i >= 0 ; i--)
			if (listOfDeals[i].money >= money) {
				System.out.println(listOfDeals[i].toString() + "\n");
				check = true;
			}
		if (!check)
			System.out.println("Find not Found!");
	}

}
