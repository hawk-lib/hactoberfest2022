
/*
time comlexity
best O(n)
worst O(n*2)
average O(n*2)
total comparison-  n(n-1)/2
 */
import java.util.Arrays;

/*Bubble sort is a sorting algorithm that compares two 
adjacent elements and swaps them until they are in the intended order.*/
public class BubbleSort {
    static void bubbleSortArray(int[] arr) {
        int size = arr.length;
        // accesing each element in array
        for (int i = 0; i < size; i++)
            // check if swapping occurs
            boolean swapped = false;
            // comparing element in array
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                if(!swapped){
                    break;
                }
    }

    public static void main(String[] args) {
        int[] arr = { -2, 45, 0, 11, -9 };
        bubbleSortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}