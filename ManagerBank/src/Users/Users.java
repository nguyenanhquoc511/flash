package Users;

import java.io.*;
import java.util.*;
import Function.*;

public class Users {
	Function F = new Function();
	Scanner objSc = new Scanner(System.in);
	Random generator = new Random(9999);
	
	protected int kind;
	protected String name, address, phone;
	protected long id;
	private String password;
	private int verificationCode;

	public Users() {
		this.kind = 0;
		this.name = null;
		this.address = null;
		this.id = 0;
		this.password = null;
		this.verificationCode = 0;
	}

	public Users(long id, String name, String address, String password, int kind, int verificationCode, String phone) {
		this.address = address;
		this.id = id;
		this.name = name;
		this.password = password;
		this.kind = kind;
		this.verificationCode = verificationCode;
		this.phone = phone;

	}
	
	public String getPhone() {
		return phone;
	}

	public boolean setPhone(String phone) {
		if (phone.isEmpty()) {
			System.out.println("Can not Empty, Try again !!");
			return false;
		}
		this.phone = phone;
		return true;
	}

	public int getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	public int getKind() {
		return kind;
	}

	public boolean setKind(int kind) {
		if (kind < 1 || kind > 3) {
			System.out.println("Value not Available, Try again!!");
			return false;
		}
		this.kind = kind;
		return true;
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name.isEmpty()) {
			System.out.println("Can not Empty, Try again !!");
			return false;
		}
		this.name = name;
		return true;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		if (address.isEmpty()) {
			System.out.println("Can not Empty, Try again !!");
			return false;
		}
		this.address = address;
		return true;
	}

	public long getId() {
		return id;
	}

	public boolean setId(long id) {
		if (id <= 0) {
			System.out.println("Value not available, Try again !!");
			return false;
		}
		this.id = id;
		return true;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password) {
		if (password.isEmpty()) {
			System.out.println("Can not Empty, Try again !!");
			return false;
		}
		this.password = password;
		return true;
	}

	public void input(listUsers LU) throws IOException {
		String name, address, password;
		long id;
		
		do {
			System.out.print("Input ID: ");
			id = (int) Math.floor(((Math.random() * 899999) + 100000));
			
		} while (!setId(id) || !F.checkId(LU, id));
		System.out.println(id);
		do {
			System.out.print("Input Name: ");
			name = objSc.nextLine();
		} while (!setName(name));

		do {
			System.out.print("Input Address: ");
			address = objSc.nextLine();
		} while (!setAddress(address));
		
		do {
			System.out.print("Input Phone: ");
			phone = objSc.nextLine();
		} while (!setPhone(phone));

		do {
			System.out.print("Input Password: ");
			password = objSc.nextLine();
		} while (!setPassword(password));

	}

	public String toString() {
		return "\nID: " + String.valueOf(getId()) + "\nName: " + getName() + "\nAddress: " + getAddress() + "\nPhone: " + getPhone() ;
	}

}
