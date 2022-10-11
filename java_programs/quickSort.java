import java.util.*;

public class Main{
    public static void main(String[] args) {
		int[] arr = {4 , 5 , 1 , 2 , 3};
		quick(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
}


static void quick(int[] nums , int low , int high) {
    if(low >= high) {
        return;
    }
    int s = low;
    int e = high;
    int mid = s + (e-s)/2;
    int pivot = nums[mid];
    
    while(s <= e) {
        while(nums[s] < pivot) {
            s++;
        }
        while(nums[e] > pivot) {
            e--;
        }
        
        if(s <= e) {
            swap(nums , s ,e);
            s++;
            e--;
        }
    }
    //now pivot is at correct index , please sort correct index
    quick(nums , low ,e);
    quick(nums , s , high);
}	

static void swap(int[] arr , int first , int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
}
}