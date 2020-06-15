package quoc2;

import java.util.*;

public class demo {

	public static void main(String[] args) {
		Scanner objSc = new Scanner(System.in);
		account[] listOfAcc = new account[20];
		listAccount list = new listAccount();

		int number;
		long id;
		String pass;
		String name;

		// nhap du lieu khach hang
		System.out.print("Input number user: ");
		number = objSc.nextInt();
		list.inputList(listOfAcc, number);

		// sign in
		boolean check = false;

		do {
			System.out.println();
			System.out.println("Sign in");
			System.out.print("ID: ");
			id = objSc.nextLong();
			objSc.nextLine();
			System.out.print("Password: ");
			pass = objSc.nextLine();
			if (!list.signIn(listOfAcc, number, id, pass))
				System.out.println("Sign In failed. ID or Password not correct! Try again!");
		} while (!list.signIn(listOfAcc, number, id, pass));

		// function
		int location, choose;
		double money, rate = 0.05, pay = 1100;

		if (list.signIn(listOfAcc, number, id, pass)) {

			location = list.findLocId(listOfAcc, number, id);

			System.out.println();
			System.out.println("Hello " + listOfAcc[location].name);
			System.out.println("Please choose function: ");
			System.out.println("1: Plug out Money");
			System.out.println("2: Put on Money");
			System.out.println("3: Transfer");
			System.out.println("4: See more information");
			System.out.println();
			System.out.print("Your choose: ");
			choose = objSc.nextInt();
			System.out.println();

			switch (choose) {
			case 1: {
				do {
					System.out.print("Input Money need Plug out: ");
					money = objSc.nextDouble();
					if ((money + pay) > listOfAcc[location].money)
						System.out.println("Not enough money, Please try again! ");
				} while ((money + pay) > listOfAcc[location].money);

				listOfAcc[location].plugOutMoney(money, 0);
				System.out.println("Plug out Success! ");
				listOfAcc[location].toPrint();
				break;
			}
			case 2: {
				do {
					System.out.print("Input Money need Put on: ");
					money = objSc.nextDouble();
					if (money <= 0)
						System.out.println("Value is not available, Please try again! ");
				} while (money <= 0);

				listOfAcc[location].putOnMoney(money, 0);
				System.out.println("Put on Success! ");
				listOfAcc[location].toPrint();
				break;
			}
			case 3: {
				do {
					System.out.print("Input receiver Id: ");
					id = objSc.nextLong();
					if (list.findLocId(listOfAcc, number, id) == -1)
						System.out.println("Id receiver is not available, Please try again! ");
				} while (list.findLocId(listOfAcc, number, id) == -1);

				do {
					System.out.print("Input Money need Transfer: ");
					money = objSc.nextDouble();
					if ((money + pay + money * rate) > listOfAcc[location].money)
						System.out.println("Not enough money, Please try again! ");
				} while ((money + pay + money * rate) > listOfAcc[location].money);

				listOfAcc[location].transfer(listOfAcc[list.findLocId(listOfAcc, number, id)], money);
				;
				System.out.println("Transfer Success! ");
				listOfAcc[location].toPrint();
				listOfAcc[list.findLocId(listOfAcc, number, id)].toPrint();
				break;

			}
			case 4: {
				listOfAcc[location].toPrint();
				break;
			}

			default:
				System.out.println("Your choose not available!");

			}

			System.out.println();
			System.out.println("Statistics: ");
			list.outputList(listOfAcc, number);

			System.out.println();
			System.out.println("Sort by money: ");
			list.sort(listOfAcc, number);
			System.out.println();
			list.outputList(listOfAcc, number);

			System.out.println();
			System.out.println("Sum money on bank: " + list.sum(listOfAcc, number));
			System.out.println();

			System.out.println("1: Find customer by Id ");
			System.out.println("2: Find customers by Name");
			System.out.println();
			System.out.print("Your choose: ");
			choose = objSc.nextInt();
			objSc.nextLine();
			System.out.println();

			switch (choose) {
			case 1: {
				System.out.print("Input Id: ");
				id = objSc.nextLong();
				list.findId(listOfAcc, number, id);
				break;
			}
			case 2: {
				System.out.print("Input Name: ");
				name = objSc.nextLine();
				list.findName(listOfAcc, number, name);
				break;
			}
			default:
				System.out.println("Your choose not available!");
			}
		}
	}
}
