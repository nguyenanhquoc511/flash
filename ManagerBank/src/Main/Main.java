package Main;

import java.io.*;
import java.util.*;
import Users.*;
import Function.*;
import Deals.*;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner objSc = new Scanner(System.in);
		Users user = new Users();
		Customer cus = new Customer();
		Customer cusR = new Customer();
		Employee emp = new Employee();
		listUsers LU = new listUsers();
		Function F = new Function();
		listDeals LD = new listDeals();
		Manager man = new Manager();

		int number, kind, choose, choose1, location, verificationCode, choose2, choose3, con;
		long id, idReceive, idCustomer, idDeal = 0;
		String password, note, name, date, password1, password2;
		double money;

		LU.initList();
		LD.initList();

		System.out.print("\nInput Data\nInput number users: ");
		number = objSc.nextInt();
		for (int i = 0; i < number; i++) {
			do {
				System.out.print("\nChoose Kind of User:\n1.Customer\n2.Employee\n3.Manager\n\nYour choose:  ");
				kind = objSc.nextInt();
				if (kind < 1 || kind > 3)
					System.out.println("Value not available, Try again!!");
			} while (kind < 1 || kind > 3);

			if (kind == 1) {
				user = new Customer();
				user.input(LU);
				user.setKind(kind);
				LU.addUsers(user);

			} else if (kind == 2) {
				user = new Employee();
				user.input(LU);
				user.setKind(kind);
				LU.addUsers(user);

			} else {
				user = new Manager();
				user.input(LU);
				user.setKind(kind);
				LU.addUsers(user);
			}
		}
		//
		do {

			do {
				System.out.print("\n1.Log In\n2.Exit\nYour Choose: ");
				choose = objSc.nextInt();
				if (choose < 1 || choose > 2)
					System.out.println("Value not available, Try again!!");
			} while (choose < 1 || choose > 2);

			// Sign In
			if (choose == 1) { //
				do {
					System.out.print("\nID: ");
					id = objSc.nextLong();
					System.out.print("Password: ");
					objSc.nextLine();
					password = objSc.nextLine();
				} while (!F.signIn(LU, id, password));

				location = LU.findById(id);
				System.out.println("\nInformation \n" + LU.listOfUsers[location].toString());

				// Kind of Users (LU.listOfUsers[location].getKind())

				// Customer

				if (LU.listOfUsers[location].getKind() == 1) {
					do {
						do {
							System.out.print(
									"\n1.Put On Money\n2.Get Out Money\n3.Transfer Money\n4.Show Information\n5.Show History Deals\n6.Change Password\nYour Choose: ");
							choose1 = objSc.nextInt();
							if (choose1 < 1 || choose1 > 6)
								System.out.println("Value not available, Try again!!");
						} while (choose1 < 1 || choose1 > 6);

						switch (choose1) {

						// Put On Money
						case 1: {
							do {
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								note = "Not Note";
								cus = (Customer) LU.listOfUsers[location];

							} while (!cus.putOnMoney(money));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (!F.checkId(LD, idDeal));
							Deal D = new Deal(idDeal, choose1, F.dateToString(), F.timeToString(), cus.getId(), money,
									cus.getId(), note);
							System.out.println("\n Information Deal\n" + D.toString());
							LD.addDeals(D);
							break;
						}
						// Get Out Money
						case 2: {
							do {
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								note = "Not Note";

								cus = (Customer) LU.listOfUsers[location];
							} while (!cus.getOutMoney(money));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (!F.checkId(LD, idDeal));
							Deal D = new Deal(idDeal, choose1, F.dateToString(), F.timeToString(), cus.getId(), money,
									cus.getId(), note);
							System.out.println("\n Information Deal\n" + D.toString());
							LD.addDeals(D);
							break;
						}
						// Transfer Money
						case 3: {
							do {
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								do {
									System.out.print("Input ID Receive: ");
									idReceive = objSc.nextLong();
								} while (!LU.checkId(idReceive, 1));
								System.out.print("Input Note: ");
								objSc.nextLine();
								note = objSc.nextLine();

								cus = (Customer) LU.listOfUsers[location];
								cusR = (Customer) LU.listOfUsers[LU.findById(idReceive)];
							} while (!cus.transferMoney(cusR, money));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (!F.checkId(LD, idDeal));
							Deal D = new Deal(idDeal, choose1, F.dateToString(), F.timeToString(), cus.getId(), money,
									idReceive, note);
							System.out.println("\n Information Deal\n" + D.toString());
							LD.addDeals(D);
							break;
						}
						// Show Infomation
						case 4: {
							System.out.println("\nInformation \n" + LU.listOfUsers[location].toString());
							break;
						}
						// Show History Deals
						case 5: {
							cus = (Customer) LU.listOfUsers[location];
							LD.findByIdCustomer(cus.getId());
							break;
						}
						// Change Password
						case 6: {
							user = LU.listOfUsers[location];
							do {
								objSc.nextLine();
								System.out.print("Enter your Password: ");
								password = objSc.nextLine();
								System.out.print("Enter New Password: ");
								password1 = objSc.nextLine();
								System.out.print("Confirm New Password: ");
								password2 = objSc.nextLine();
							} while (!F.checkPassword(user, password) || !F.checkPassword(password1, password2));

							user.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

							System.out.println(
									"*** In display phone of Customer: " + user.getVerificationCode() + " ***");

							System.out.print("\nInput Verification Code: ");
							verificationCode = objSc.nextInt();

							F.changePassword(user, password1, verificationCode);

							break;
						}
						}
						do {
							System.out.print("Do you want continue? (1.Yes / 2.No): ");
							con = objSc.nextInt();
							if (con < 1 || con > 2)
								System.out.println("Value not available, Try again !");
						} while (con < 1 || con > 2);
					} while (con == 1);
				}

				// Employee
				else if (LU.listOfUsers[location].getKind() == 2) {
					do {
						do {
							System.out.print(
									"\n1.Put On Money\n2.Get Out Money\n3.Transfer Money\n4.Find Customers\n5.Find Deals\n6.Sign up Customer Users\n7.Delete Customer\n8.Change Password\nYour Choose: ");
							choose1 = objSc.nextInt();
							if (choose1 < 1 || choose1 > 8)
								System.out.println("Value not available, Try again!!");
						} while (choose1 < 1 || choose1 > 8);

						switch (choose1) {

						// Put On Money
						case 1: {

							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(idCustomer, 1));
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								objSc.nextLine();
								System.out.print("Input Note: ");
								note = objSc.nextLine();

								cus = (Customer) LU.listOfUsers[LU.findById(idCustomer)];

								cus.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println(
										"*** In display phone of Customer: " + cus.getVerificationCode() + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();

								emp = (Employee) LU.listOfUsers[location];

							} while (!emp.putOnMoney(cus, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (!F.checkId(LD, idDeal));
							Deal D = new Deal(idDeal, choose1, F.dateToString(), F.timeToString(), idCustomer, money,
									idCustomer, note);
							System.out.println("\n Information Deal\n" + D.toString());
							LD.addDeals(D);
							break;
						}
						// Get Out Money
						case 2: {
							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(idCustomer, 1));
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								System.out.print("Input Note: ");
								objSc.nextLine();
								note = objSc.nextLine();

								cus = (Customer) LU.listOfUsers[LU.findById(idCustomer)];

								cus.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println(
										"*** In display phone of Customer: " + cus.getVerificationCode() + " ***");

								System.out.print("Input Verification Code: ");
								verificationCode = objSc.nextInt();

								emp = (Employee) LU.listOfUsers[location];

							} while (!emp.getOutMoney(cus, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (!F.checkId(LD, idDeal));
							Deal D = new Deal(idDeal, choose1, F.dateToString(), F.timeToString(), idCustomer, money,
									idCustomer, note);
							System.out.println("\n Information Deal\n" + D.toString());
							LD.addDeals(D);
							break;
						}
						// Transfer Money
						case 3: {
							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(idCustomer, 1));
								do {
									System.out.print("Input ID Receive: ");
									idReceive = objSc.nextLong();
								} while (!LU.checkId(idReceive, 1));
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								System.out.print("Input Note: ");
								objSc.nextLine();
								note = objSc.nextLine();

								cus = (Customer) LU.listOfUsers[LU.findById(idCustomer)];
								cusR = (Customer) LU.listOfUsers[LU.findById(idReceive)];

								cus.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("\n*** In display phone of Customer: \nVerification Code: "
										+ cus.getVerificationCode() + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();

								emp = (Employee) LU.listOfUsers[location];

							} while (!emp.transferMoney(cus, cusR, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (!F.checkId(LD, idDeal));
							Deal D = new Deal(idDeal, choose1, F.dateToString(), F.timeToString(), idCustomer, money,
									idReceive, note);
							System.out.println("\n Information Deal\n" + D.toString());
							LD.addDeals(D);
							break;
						}
						// find customers
						case 4: {
							do {
								System.out.print("\n1.Find customer by ID\n2.Find customer by Name\nYour Choose: ");
								choose2 = objSc.nextInt();
								if (choose2 < 1 || choose2 > 2)
									System.out.println("Value not available, Try again!!");
							} while (choose2 < 1 || choose2 > 2);

							if (choose2 == 1) {
								System.out.print("\nInput ID: ");
								idCustomer = objSc.nextLong();
								LU.findByIdCus(idCustomer);
							} else {
								System.out.print("\nInput Name: ");
								objSc.nextLine();
								name = objSc.nextLine();
								LU.findByNameCus(name);
							}
							break;
						}
						// Find deals
						case 5: {
							do {
								System.out.print(
										"\n1.Find Deals by Money\n2.Find Deals by ID\n3.Find Deals by Date\nYour Choose: ");
								choose2 = objSc.nextInt();
								if (choose2 < 1 || choose2 > 3)
									System.out.println("Value not available, Try again!!");
							} while (choose2 < 1 || choose2 > 3);

							if (choose2 == 1) {
								System.out.print("\nInput Money: ");
								money = objSc.nextDouble();
								do {
									System.out.print("\n1.Find lower Money\n2.Find higher Money\nYour Choose: ");
									choose3 = objSc.nextInt();
									if (choose3 < 1 || choose3 > 2)
										System.out.println("Value not available, Try again!!");
								} while (choose3 < 1 || choose3 > 2);

								if (choose3 == 1)
									LD.findByLowMoney(money);
								else
									LD.findByHighMoney(money);

							} else if (choose2 == 2) {
								System.out.print("\nInput Deal ID: ");
								idDeal = objSc.nextLong();
								LD.findByIdDeals(idDeal);

							} else if (choose2 == 3) {
								System.out.print("\nInput Date: ");
								objSc.nextLine();
								date = objSc.nextLine();
								LD.findByDate(date);
							}
							break;
						}
						// Sign Up
						case 6: {
							Customer tmp = new Customer();
							F.signUp(LU, tmp);
							tmp.setKind(1);
							LU.addUsers(tmp);
							System.out.println("\nInformation " + tmp.toString());
							break;
						}
						// delete customer
						case 7: {
							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(idCustomer, 1));

								user = LU.listOfUsers[LU.findById(idCustomer)];

								user.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println(
										"*** In display phone of Customer: " + user.getVerificationCode() + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();

							} while (!F.deleteUser(LU, idCustomer, verificationCode));
							break;
						}
						// change password
						case 8: {
							user = LU.listOfUsers[location];
							do {
								objSc.nextLine();
								System.out.print("Enter your Password: ");
								password = objSc.nextLine();
								System.out.print("Enter New Password: ");
								password1 = objSc.nextLine();
								System.out.print("Confirm New Password: ");
								password2 = objSc.nextLine();
							} while (!F.checkPassword(user, password) || !F.checkPassword(password1, password2));

							user.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

							System.out.println(
									"*** In display phone of Customer: " + user.getVerificationCode() + " ***");

							System.out.print("\nInput Verification Code: ");
							verificationCode = objSc.nextInt();

							F.changePassword(user, password1, verificationCode);

							break;
						}
						}
						do {
							System.out.print("Do you want continue? (1.Yes / 2.No): ");
							con = objSc.nextInt();
							if (con < 1 || con > 2)
								System.out.println("Value not available, Try again !");
						} while (con < 1 || con > 2);
					} while (con == 1);
				} else {
					// Manager
					do {
						do {
							System.out.print(
									"\n1.Statistical\n2.Sign Up Employee Users\n3.Delete Employee\n4.Show all Users\n5.Show all Deals\n6.Change Password\nYour Choose: ");
							choose1 = objSc.nextInt();
							if (choose1 < 1 || choose1 > 6) {
								System.out.println("Value not available, Try again!");

							}
						} while (choose1 < 1 || choose1 > 6);

						switch (choose1) {
						// Statistical
						case 1: {
							man.statistical();
							break;
						}
						// Sign Up Employee Users
						case 2: {
							Employee tmp = new Employee();
							F.signUp(LU, tmp);
							tmp.setKind(2);
							LU.addUsers(tmp);
							break;
						}
						// Delete Employee
						case 3: {
							do {
								do {
									System.out.print("\nInput ID Employee: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(idCustomer, 2));

								user = LU.listOfUsers[LU.findById(idCustomer)];

							} while (!F.deleteUser(LU, idCustomer));
							break;
						}
						// Show all Users
						case 4: {
							LU.showList();
							break;
						}
						// Show all Deals
						case 5: {
							LD.showList();
							break;
						}
						// Change Password
						case 6: {
							user = LU.listOfUsers[location];
							do {
								objSc.nextLine();
								System.out.print("Enter your Password: ");
								password = objSc.nextLine();
								System.out.print("Enter New Password: ");
								password1 = objSc.nextLine();
								System.out.print("Confirm New Password: ");
								password2 = objSc.nextLine();
							} while (!F.checkPassword(user, password) || !F.checkPassword(password1, password2));

							user.setVerificationCode((int) Math.floor(((Math.random() * 899999) + 100000)));

							System.out.println(
									"*** In display phone of Customer: " + user.getVerificationCode() + " ***");

							System.out.print("\nInput Verification Code: ");
							verificationCode = objSc.nextInt();

							F.changePassword(user, password1, verificationCode);

							break;
						}

						}
						do {
							System.out.print("\nDo you want continue? (1.Yes / 2.No): ");
							con = objSc.nextInt();
							if (con < 1 || con > 2)
								System.out.println("Value not available, Try again !");
						} while (con < 1 || con > 2);
					} while (con == 1);
				}
			}
		} while (choose != 2);

	}
}
