package project1.inheritance;

public class StudentRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student();
		student1.setName("Tej pratap");
		System.out.println(student1.getName());
		
		Person person = new Person();
		String value = person.toString();
		System.out.println(value);
		System.out.println(person);

	}

}
