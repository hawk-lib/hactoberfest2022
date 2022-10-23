package project1;

import java.util.Arrays;

public class ArraysAndArrayList {
	
	static void sum(int... values) {
		System.out.println(Arrays.toString(values));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] marks= {25,54,34};
		//System.out.println(marks[0]);
		int sum=0;
		for(int mark:marks) {
			sum=sum+mark;
		}
		System.out.println(sum);
		
		int[] marks2 = new int[5]; //array of 5 int size will be created and 0 se intialized ho jayega	
		System.out.println(marks2[2]);
		
		System.out.println(marks); //we will get the memory location
		//to print the whole array using sysout
		System.out.println(Arrays.toString(marks));
		
		boolean[] boolArray = new boolean[5];
		double[] doubleArray = new double[5];
		
		class Person{}
		Person[] personArray = new Person[5]; //array of class
		for(Person person:personArray) {
			System.out.println(person);
		}
		
		//create an array with prefilled a value
		int[] prefillArray = new int[5];
		Arrays.fill(prefillArray,25);
		System.out.println(Arrays.toString(prefillArray));
		
		// to compare two arrays
		System.out.println(Arrays.equals(prefillArray, marks));
		
		//variable arguments
		sum(2,3,4); //printing through sum function where we are taking many inputs
		
		

	}

}
