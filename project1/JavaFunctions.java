package project1;

public class JavaFunctions {
	static int fun(int a,int b) {
		return a+b;
	}
	
	static void sayHelloWorld() {
		System.out.println("Hello world");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world in java");
		System.out.println(fun(5,85));
		sayHelloWorld();
		MultiplicationTable table = new MultiplicationTable();
		table.print(6);
		table.print();
		

	}
}
