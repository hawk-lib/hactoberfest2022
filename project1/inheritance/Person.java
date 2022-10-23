package project1.inheritance;

public class Person {
	private String name;
	private String email;
	private String phoneNumber;
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	//overrided the default object class function
	public String toString() {
		return name+email+phoneNumber;
	}
	

}
