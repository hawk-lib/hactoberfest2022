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

}
