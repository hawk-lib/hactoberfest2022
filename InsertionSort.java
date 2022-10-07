import java.util.*;

import java.lang.*;

import java.io.*;

//Insertion Sort

class InsertionSort {

	public static void main(String[] args){

		int[] arr = {7,2,4,1,5,3};

		for(int i=1;i<arr.length;i++){

			int hole = i;

			int val = arr[i];

			while(hole>0 && arr[hole-1]>val){

				arr[hole] = arr[hole-1];

				hole--;

			}

			arr[hole] = val;

		}

		for(int i : arr){

			System.out.print(i+" ");

		}

	}

=======
// Insertion sort in Java

import java.util.Arrays;

class InsertionSort {

  void insertionSort(int array[]) {
    int size = array.length;

    for (int step = 1; step < size; step++) {
      int key = array[step];
      int j = step - 1;

      // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<array[j] to key>array[j].
      while (j >= 0 && key < array[j]) {
        array[j + 1] = array[j];
        --j;
      }

      // Place key at after the element just smaller than it.
      array[j + 1] = key;
    }
  }

  // Driver code
  public static void main(String args[]) {
    int[] data = { 9, 5, 1, 4, 3 };
    InsertionSort is = new InsertionSort();
    is.insertionSort(data);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
}
