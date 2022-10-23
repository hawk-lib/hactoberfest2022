package project1;

public class CustomerRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address myhomeaddress = new Address("saguna more","danapur","Bihar");
		Address myworkaddress = new Address("dwarka sec-12","dwarka","New Delhi");
		
		Customer customer = new Customer("Tej Pratap",myhomeaddress);
		customer.setWorkAddress(myworkaddress);
		System.out.println(customer);
		System.out.println(customer.getHomeAddress().toString());
		System.out.println(customer.getWorkAddress());

	}

}
