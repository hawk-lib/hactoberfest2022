package project1;

import java.util.ArrayList;

public class MyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("apple");
		arrayList.add("banana");
		arrayList.add("grapes");
		System.out.println(arrayList);
		arrayList.remove("apple");
		arrayList.remove(0);
		System.out.println(arrayList);

	}

}
