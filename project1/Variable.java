package project1;

import java.math.BigDecimal;

public class Variable {
	static int b=9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b=5; //-128 to 127 (8bits)
		short s=14444; //-32768 to 32767 (16 bits)
		int a=522862; // (32 bits) 
		long lval=434343;
		float f=4.5f;
		double d = 67.0;
		char ch='A';
		boolean isTrue = false;
		//System.out.println(a+b);
		
		//Byte
		System.out.println("size of byte: "+Byte.SIZE);
		System.out.println("Maximum value a byte can hold: "+Byte.MAX_VALUE);
		System.out.println("Minimum value a byte can hold: "+Byte.MIN_VALUE);
		
		//Short
		System.out.println("size of short: "+Short.SIZE);
		System.out.println("Maximum value a short can hold: "+Short.MAX_VALUE);
		System.out.println("Minimum value a short can hold: "+Short.MIN_VALUE);
		
		//Integer
		System.out.println("size of int: "+Integer.SIZE);
		System.out.println("Maximum value a int can hold: "+Integer.MAX_VALUE);
		System.out.println("Minimum value a int can hold: "+Integer.MIN_VALUE);
		
		//Long
		System.out.println("size of long: "+Long.SIZE);
		System.out.println("Maximum value a long can hold: "+Long.MAX_VALUE);
		System.out.println("Minimum value a long can hold: "+Long.MIN_VALUE);
		
		long l =345553l; //long ke end me l lagate hain
		int i=(int)l; //typecasting long to int
		System.out.println(i);
		
		//floating point data types
		//by default the value is of double type -> 8 bytes 
		//float is of 4 bytes
		float f1 = 14.55f;
		double d1 = 34.21124;
		System.out.println(f1);
		System.out.println(d1);
		
		int i2 = (int)f1;
		System.out.println(i2);
		System.out.println(f1+d1);  //yahan pr value jyada bdi aa jati hai 
		//thats why big decimal use krte hain
		
		//big decimal
		BigDecimal number1 = new BigDecimal("15.55");
		BigDecimal number2 = new BigDecimal("34.21124");
		System.out.println(number1.add(number2)); //this gives the accurate output
		//typecasted int to bigdecimal
		System.out.println(number1.add(new BigDecimal(i2)));
		System.out.println(number1.multiply(new BigDecimal(i2)));
		System.out.println(number1.subtract(new BigDecimal(i2)));
		//System.out.println(number1.divide(new BigDecimal(i2)));
		System.out.println(number1.remainder(new BigDecimal(i2)));
		
		//boolean
		boolean bool = true;
		boolean bool1 = false;
		//boolean bool2=0; =>this is not acceptable in java
		if(bool) {
			System.out.println("this is true");
		}
		
		// ^ exor condition dono same then false else true
		System.out.println(true^true);
		System.out.println(true^false);
		
		//char data type
		char ch1='a';
		char ch2='\u0022';// \u0022 is the unicode every character has a unicode if we canot type due to some 
				//condition we can write its unicode
		System.out.println(ch2);
		char ch3 = 65;
		System.out.println(ch3);
		
		char ch4='D';
		System.out.println((int)ch4);
		
		
	}

}
