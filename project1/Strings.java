package project1;

public class Strings {
	public static void main(String[] args) {
		String str = "this is my string";
		System.out.println(str.length());
		System.out.println(str.charAt(0));
		System.out.println(str.substring(5)); //after 5th letter everything will be printed
		System.out.println(str.substring(0,5)); //5th letter will be includes
		System.out.println(str.indexOf("is")); //this wale is ka index-2 so 2 print ho rha hai
		System.out.println(str.contains("my")); //will return true or false
		System.out.println(str.startsWith("is"));
		System.out.println(str.startsWith("th"));
		System.out.println(str.endsWith("th"));
		System.out.println(str.isEmpty());
		System.out.println(str.equals("this is my string"));
		System.out.println(str.equalsIgnoreCase(str));
		
		String str1 = "another string";
		System.out.println(str.concat(str1));
		System.out.println(str); //content of str change nhi hoga whi hoga
		
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		//join and replace methods
		String a="A";
		String b="B";
		String c="C";
		String d="D";
		
		String joint = String.join(",",b,c,d); //jahan jahan , hoga whan se join kr dega
		System.out.println(joint);
		System.out.println(joint.replace("B","C")); //B ko C se replace kr diye
		//user str. to show all methods
		
	}

}
