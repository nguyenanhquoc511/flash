package Deals;

public class Deal {

	protected long idDeal, idCustomer, idReceive;
	protected String date, time, note;
	protected double money;
	protected String kind;

	public Deal() {
		this.date = null;
		this.idCustomer = 0;
		this.idDeal = 0;
		this.idReceive = 0;
		this.kind = null;
		this.money = 0;
		this.note = null;
		this.time = null;
	}

	public Deal(long idDeal, String kind, String date, String time, long idCustomer, double money, long idReceive,
			String note) {
		this.date = date;
		this.idCustomer = idCustomer;
		this.idDeal = idDeal;
		this.idReceive = idReceive;
		this.kind = kind;
		this.money = money;
		this.note = note;
		this.time = time;
	}

	public long getIdDeal() {
		return idDeal;
	}

	public void setIdDeal(long idDeal) {
		this.idDeal = idDeal;
	}

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public long getIdReceive() {
		return idReceive;
	}

	public void setIdReceive(long idReceive) {
		this.idReceive = idReceive;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
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
			this.kind = "Put On Money";
		else if (kind == 2)
			this.kind = "Get Out Money";
		else
			this.kind = "Transfer Money";

		return true;

	}

	//id~~kind~~date~~time~~idcustomer~~money~~idreceive~~note
	public String toString() {
		return String.valueOf(idDeal) + "~~" + getKind() + "~~" + date + "~~" + time + "~~"
				+ String.valueOf(idCustomer) + "~~" + String.valueOf(money) + "~~" + String.valueOf(idReceive) + "~~"
				+ note;
	}

}
