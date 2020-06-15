package Main;

import java.io.*;
import java.util.*;
import Users.*;
import Function.*;
import Deals.*;
import File.FileProcess;

public class Main {

	public static void main(String[] args) throws NumberFormatException, Exception {

		Scanner objSc = new Scanner(System.in);
		FileProcess file = new FileProcess();
		Customer cus = new Customer();

		listUsers LU = new listUsers();
		Function F = new Function();
		listDeals LD = new listDeals();
		Manager man = new Manager();
		File fu = new File("./USERSFILE.INP");
		File fd = new File("./DEALSFILE.INP");
		fu.createNewFile();
		fd.createNewFile();

		int choose, choose1, location, verificationCode, choose2, choose3, con, numberUsers, numberDeals;
		long id, idReceive, idCustomer, idDeal = 0;
		String password, note, name, date, password1, password2;
		double money;

		String[] arrInfo = new String[1000];
		String[] arrDeal = new String[1000];

		numberUsers = file.readFile(arrInfo, "./USERSFILE.INP");
		numberDeals = file.readFile(arrDeal, "./DEALSFILE.INP");

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
				} while (!F.signIn(arrInfo, numberUsers, id, password));

				location = LU.findById(arrInfo, numberUsers, id);
				String[] arrUserTmp = arrInfo[location].split("~~");
				System.out.println("\nInformation \n");
				F.showInfo(arrInfo[location]);

				// Customer

				if (arrUserTmp[6].equals("Customer")) {
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
							String[] arrUser = arrInfo[location].split("~~");
							String tmpStr;
							do {
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								note = "Not Note";

								arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();
								tmpStr = F.changeArrStringToString(arrUser);

							} while (!F.putOnMoney(arrInfo, numberUsers, tmpStr, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (F.checkIdDeal(arrDeal, numberDeals, idDeal));

							Deal D = new Deal(idDeal, "Put On Money", F.dateToString(), F.timeToString(),
									Long.parseLong(arrUser[0]), money, Long.parseLong(arrUser[0]), note);
							System.out.println("\n Information Deal\n");
							F.showDeal(D.toString());
							LD.addDeal(arrDeal, numberDeals, D);
							numberDeals++;
							// System.out.println("hello");
							break;
						}
						// Get Out Money
						case 2: {
							String tmpStr;
							String[] arrUser = arrInfo[location].split("~~");
							do {
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								note = "Not Note";

								arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();
								tmpStr = F.changeArrStringToString(arrUser);

							} while (!F.getOutMoney(arrInfo, numberUsers, tmpStr, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (F.checkIdDeal(arrDeal, numberDeals, idDeal));

							Deal D = new Deal(idDeal, "Get  Money", F.dateToString(), F.timeToString(),
									Long.parseLong(arrUser[0]), money, Long.parseLong(arrUser[0]), note);
							System.out.println("\n Information Deal\n");
							F.showDeal(D.toString());
							LD.addDeal(arrDeal, numberDeals, D);
							numberDeals++;
							// System.out.println("hello");
							break;
						}
						// Transfer Money
						case 3: {
							String tmpStr;
							String[] arrUser = arrInfo[location].split("~~");
							do {
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								do {
									System.out.print("Input ID Receive: ");
									idReceive = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idReceive, "Customer"));
								System.out.print("Input Note: ");
								objSc.nextLine();
								note = objSc.nextLine();

								arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();

								tmpStr = F.changeArrStringToString(arrUser);

							} while (!F.transferMoney(arrInfo, numberUsers, tmpStr,
									arrInfo[LU.findById(arrInfo, numberUsers, idReceive)], money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (F.checkIdDeal(arrDeal, numberDeals, idDeal));

							Deal D = new Deal(idDeal, "Transfer Money", F.dateToString(), F.timeToString(),
									Long.parseLong(arrUser[0]), money, idReceive, note);
							System.out.println("\n Information Deal\n");
							F.showDeal(D.toString());
							LD.addDeal(arrDeal, numberDeals, D);
							numberDeals++;
							break;
						}
						// Show Infomation
						case 4: {
							System.out.println("\nInformation \n");
							F.showInfo(arrInfo[location]);
							break;
						}
						// Show History Deals
						case 5: {
							System.out.println("\nHistory Deals \n");
							LD.findByIdCus(arrDeal, numberDeals, id);
							break;
						}
						// Change Password
						case 6: {
							String tmpStr;
							String[] arrUser = arrInfo[location].split("~~");
							do {
								objSc.nextLine();
								System.out.print("Enter your Password: ");
								password = objSc.nextLine();
								System.out.print("Enter New Password: ");
								password1 = objSc.nextLine();
								System.out.print("Confirm New Password: ");
								password2 = objSc.nextLine();
							} while (!F.checkPasswordUser(arrInfo[location], password)
									|| !F.checkPassword(password1, password2));

							arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

							System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

							System.out.print("\nInput Verification Code: ");
							verificationCode = objSc.nextInt();
							tmpStr = F.changeArrStringToString(arrUser);
							F.changePassword(arrInfo, numberUsers, tmpStr, password1, verificationCode);

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
				else if (arrUserTmp[6].equals("Employee")) {
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
							String tmpStr;
							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idCustomer, "Customer"));
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								note = "Not Note";

								String[] arrCus = arrInfo[LU.findById(arrInfo, numberUsers, idCustomer)].split("~~");

								arrCus[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrCus[5] + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();
								tmpStr = F.changeArrStringToString(arrCus);

							} while (!F.putOnMoney(arrInfo, numberUsers, tmpStr, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (F.checkIdDeal(arrDeal, numberDeals, idDeal));

							Deal D = new Deal(idDeal, "Put On Money", F.dateToString(), F.timeToString(), idCustomer,
									money, idCustomer, note);
							System.out.println("\n Information Deal\n");
							F.showDeal(D.toString());
							LD.addDeal(arrDeal, numberDeals, D);
							numberDeals++;
							// System.out.println("hello");
							break;
						}
						// Get Out Money
						case 2: {
							String tmpStr;
							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idCustomer, "Customer"));
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								note = "Not Note";

								String[] arrCus = arrInfo[LU.findById(arrInfo, numberUsers, idCustomer)].split("~~");

								arrCus[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrCus[5] + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();
								tmpStr = F.changeArrStringToString(arrCus);

							} while (!F.getOutMoney(arrInfo, numberUsers, tmpStr, money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (F.checkIdDeal(arrDeal, numberDeals, idDeal));

							Deal D = new Deal(idDeal, "Get Out Money", F.dateToString(), F.timeToString(), idCustomer,
									money, idCustomer, note);
							System.out.println("\n Information Deal\n");
							F.showDeal(D.toString());
							LD.addDeal(arrDeal, numberDeals, D);
							numberDeals++;
							// System.out.println("hello");
							break;
						}
						// Transfer Money
						case 3: {
							String tmpStr;
							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idCustomer, "Customer"));
								do {
									System.out.print("Input ID Receive: ");
									idReceive = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idReceive, "Customer"));
								System.out.print("Input Money: ");
								money = objSc.nextDouble();
								System.out.print("Input Note: ");
								objSc.nextLine();
								note = objSc.nextLine();

								String[] arrCus = arrInfo[LU.findById(arrInfo, numberUsers, idCustomer)].split("~~");

								arrCus[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrCus[5] + " ***");

								System.out.print("\nInput Verification Code: ");

								verificationCode = objSc.nextInt();
								tmpStr = F.changeArrStringToString(arrCus);

							} while (!F.transferMoney(arrInfo, numberUsers, tmpStr,
									arrInfo[LU.findById(arrInfo, numberUsers, idReceive)], money, verificationCode));
							do {
								idDeal = (int) Math.floor(((Math.random() * 899999) + 100000));
							} while (F.checkIdDeal(arrDeal, numberDeals, idDeal));

							Deal D = new Deal(idDeal, "Get Out Money", F.dateToString(), F.timeToString(), idCustomer,
									money, idReceive, note);
							System.out.println("\n Information Deal\n");
							F.showDeal(D.toString());
							LD.addDeal(arrDeal, numberDeals, D);
							numberDeals++;
							// System.out.println("hello");
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
								LU.findByIdCus(arrInfo, numberUsers, idCustomer);
							} else {
								System.out.print("\nInput Name: ");
								objSc.nextLine();
								name = objSc.nextLine();
								LU.findByNameCus(arrInfo, numberUsers, name);
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
									LD.findByLowMoney(arrDeal, numberDeals, money);
								else
									LD.findByHighMoney(arrDeal, numberDeals, money);

							} else if (choose2 == 2) {
								System.out.print("\nInput Deal ID: ");
								idDeal = objSc.nextLong();
								LD.findByIdDeals(arrDeal, numberDeals, idDeal);

							} else if (choose2 == 3) {
								System.out.print("\nInput Date: ");
								objSc.nextLine();
								date = objSc.nextLine();
								LD.findByDate(arrDeal, numberDeals, date);
							}
							break;
						}
						// Sign Up
						case 6: {
							Customer tmp = new Customer();
							F.signUp(arrInfo, numberUsers, tmp);
							tmp.setKind(1);
							LU.addUsers(arrInfo, numberUsers, tmp);
							numberUsers++;
							System.out.println("\nInformation ");
							F.showInfo(tmp.toString());
							break;
						}
						// delete customer
						case 7: {
							String tmpStr;

							do {
								do {
									System.out.print("\nInput ID Customer: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idCustomer, "Customer"));

								String[] arrUser = arrInfo[LU.findById(arrInfo, numberUsers, idCustomer)].split("~~");

								arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

								System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

								System.out.print("\nInput Verification Code: ");
								verificationCode = objSc.nextInt();
								tmpStr = F.changeArrStringToString(arrUser);

							} while (!F.deleteUser(arrInfo, numberUsers, tmpStr, verificationCode));
							numberUsers--;
							break;
						}
						// change password
						case 8: {
							String tmpStr;
							String[] arrUser = arrInfo[location].split("~~");
							do {
								objSc.nextLine();
								System.out.print("Enter your Password: ");
								password = objSc.nextLine();
								System.out.print("Enter New Password: ");
								password1 = objSc.nextLine();
								System.out.print("Confirm New Password: ");
								password2 = objSc.nextLine();
							} while (!F.checkPasswordUser(arrInfo[location], password)
									|| !F.checkPassword(password1, password2));

							arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

							System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

							System.out.print("\nInput Verification Code: ");
							verificationCode = objSc.nextInt();
							tmpStr = F.changeArrStringToString(arrUser);
							F.changePassword(arrInfo, numberUsers, tmpStr, password1, verificationCode);

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
							F.signUp(arrInfo, numberUsers, tmp);
							tmp.setKind(2);
							LU.addUsers(arrInfo, numberUsers, tmp);
							F.showInfo(tmp.toString());
							numberUsers++;
							break;
						}
						// Delete Employee
						case 3: {
							String tmpStr;
							do {
								do {
									System.out.print("\nInput ID Employee: ");
									idCustomer = objSc.nextLong();
								} while (!LU.checkId(arrInfo, numberUsers, idCustomer, "Employee"));

								String[] arrUser = arrInfo[LU.findById(arrInfo, numberUsers, idCustomer)].split("~~");
								tmpStr = F.changeArrStringToString(arrUser);
							} while (!F.deleteUser(arrInfo, numberUsers, tmpStr));
							numberUsers--;
							break;
						}
						// Show all Users
						case 4: {
							LU.showList(arrInfo, numberUsers);
							break;
						}
						// Show all Deals
						case 5: {
							LD.showDeal(arrDeal, numberDeals);
							break;
						}
						// Change Password
						case 6: {
							String tmpStr;
							String[] arrUser = arrInfo[location].split("~~");
							do {
								objSc.nextLine();
								System.out.print("Enter your Password: ");
								password = objSc.nextLine();
								System.out.print("Enter New Password: ");
								password1 = objSc.nextLine();
								System.out.print("Confirm New Password: ");
								password2 = objSc.nextLine();
							} while (!F.checkPasswordUser(arrInfo[location], password)
									|| !F.checkPassword(password1, password2));

							arrUser[5] = String.valueOf((int) Math.floor(((Math.random() * 899999) + 100000)));

							System.out.println("*** In display phone of Customer: " + arrUser[5] + " ***");

							System.out.print("\nInput Verification Code: ");
							verificationCode = objSc.nextInt();
							tmpStr = F.changeArrStringToString(arrUser);
							F.changePassword(arrInfo, numberUsers, tmpStr, password1, verificationCode);

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
