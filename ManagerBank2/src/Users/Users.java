package Users;

import java.util.*;

public class Users {
	Scanner objSc = new Scanner(System.in);
	Random generator = new Random(9999);

	protected String kind;
	protected String name, address, phone;
	protected long id;
	private String password;
	private int verificationCode;

	public Users() {
		this.kind = null;
		this.name = null;
		this.address = null;
		this.id = 0;
		this.password = null;
		this.verificationCode = 0;
	}

	public Users(long id, String name, String address, String password, String kind, int verificationCode,
			String phone) {
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

	public String getKind() {
		return kind;
	}

	public boolean setKind(int kind) {
		if (kind < 1 || kind > 3) {
			System.out.println("Value not Available, Try again!!");
			return false;
		}

		if (kind == 1)
			this.kind = "Customer";
		else if (kind == 2)
			this.kind = "Employee";
		else
			this.kind = "Manager";

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

	public String toString() {
		return String.valueOf(getId()) + "~~" + getName() + "~~" + getAddress() + "~~" + getPhone() + "~~"
				+ getPassword() + "~~" + String.valueOf(getVerificationCode()) + "~~" + getKind() + "~~";
	}

}
