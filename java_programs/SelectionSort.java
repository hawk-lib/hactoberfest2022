import java.util.*;

import java.lang.*;

import java.io.*;

//selection Sort

class SelectionSort {

	public static void main(String[] args){

		int[] arr = {2,7,4,1,5,3};

		for(int i=0;i<arr.length;i++){

			int minVal = arr[i];

			int ind = i;

			for(int j= i+1;j<arr.length;j++){

				if(arr[j] < minVal){

					ind = j;

					minVal = arr[j];

				}

			}

			//swap with minimum 

			int temp = arr[i];

			arr[i] = minVal;

			arr[ind] = temp;

		}

		for(int i : arr){

			System.out.print(i+" ");

		}

	}

}

