package quoc7;

public class student extends object{
	private int id;
	private String name, address;
	private long phone;
	
	public int getId() {
		return id;
	}
	public boolean setId(int id) {
		if(id <= 0)
			return false;
		this.id = id;
		return true;
		
	}
	
	public String getName() {
		return name;
	}
	
	public boolean setName(String name) {
		if(name.equals(""))
			return false;
		this.name = name;
		return true;
	}
	
	public String getAddress() {
		return address;
	}
	
	public boolean setAddress(String address) {
		if(address.equals(""))
			return false;
		this.address = address;
		return true;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public boolean setPhone(long phone) {
		if(phone < 1000000 || phone > 9999999)
			return false;
		this.phone = phone;
		return true;
	}
	
	student(){
		this.id = 0;
		this.address = "";
		this.name = "";
		this.phone = 0;
	}
	
	student(int id, String name, String address, long phone){
		this.id = id;
		this.address = address;
		this.name = name;
		this.phone = phone;
	}
	
	public String toString() {
	return "Id: "+ String.valueOf(getId()) +"\t\tName: "+ getName() +"\t\tAddress: "+ getAddress()+ "\t\tPhone: "+String.valueOf(getPhone());
	}
}
