package project1;

import java.util.Scanner;

public class Conditionals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=25;
		if(i==25) {
			System.out.println("i is equal to 25");
		}
		if(i != 25) {
			System.out.println("i is not equal to 25");
		}
		else {
			System.out.println("i is not equal to 25 else condtion");
		}
		
		//isme if(i==25) and else condtion dono run ho ja rhe hain then hmlog else if ka use krte hain
		
		
		i=24;
		
		if(i==25) {
			System.out.println("i is equal to 25");
		}
		else if(i == 24) {
			System.out.println("i is not equal to 25");
		}
		else {
			System.out.println("i is not equal to 24 else condtion");
		}
		
		//isme ek condtion match hone pr aage nhi jayega 
		//only one block is executed in nested else if condition 
		
		//taking user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int input1 = scanner.nextInt();
		System.out.println("You entered: "+input1);
		
		//small calculator program
		System.out.print("Enter a number: ");
		int input2 = scanner.nextInt();
		System.out.println("1 : ADD");
		System.out.println("2 : SUBSTRACT");
		System.out.println("3 : MULTIPLY");
		System.out.println("4 : DIVIDE");
		
		System.out.println("Enter your input: ");
		
		int usInput = scanner.nextInt();
		if(usInput ==1) {
			int res = input1+input2;
			System.out.println(res);
		}
		if(usInput ==2) {
			int res = input1-input2;
			System.out.println(res);
		}
		if(usInput ==3) {
			int res = input1*input2;
			System.out.println(res);
		}
		if(usInput ==4) {
			int res = input1/input2;
			System.out.println(res);
		}
		
		
		
		

	}

}
