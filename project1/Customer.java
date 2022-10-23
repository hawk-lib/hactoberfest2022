package project1;

public class Customer {
	//state
	private String name;
	private Address homeAddress;
	private Address workAddress;
	
	
	//constructor
	public Customer(String name,Address homeAddress) {
		this.name=name;
		this.homeAddress=homeAddress;
	}

	//setters & getters
	public Address getHomeAddress() {
		return homeAddress;
	}


	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}


	public Address getWorkAddress() {
		return workAddress;
	}


	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
	
	public String toString() {
		return String.format("Name=[%s] HomeAdd=[%s] WorkAdd=[%s]",name,homeAddress.toString(),workAddress.toString());
	}
	

	
	
	
	//methods
}
