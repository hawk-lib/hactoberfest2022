package File6_Recursion;

public class V13BubbleSort {
    public static void main(String[] args) {

        int[] arr = {50,40,8,20,10};

        bsort(arr, 0, arr.length-1);
        for(int v:arr){
            System.out.print(v+" ");
        }
    }

    public static void bsort(int[] arr, int si, int li) {
        // STEP 4
        // Base Case 2: humara last index decrement ho ho k 0 pohch gya means it's time to stop, hum index 1 se le k aage end tak k saare elements ko unki correct position de chuke hain. matlab index 0 wala element b automatically sahi position pr hai
        if (li == 0) {
            return;
        }

        // STEP 3
        // Base Case 1: hume adjacent elements ka comparison krte krte jab end tak pohch jayenge, that means humne end k elemnt ko uski sahi position de d hai(means largest element is on last index now).....So, ab hum last index ko decrement karenge becasue asb hume last second index pe sahi element ko daalna hai or starting index ko 0 kr denge taaki comparison starting se start ho jaye
        // Aise he hum last index se le k 1st index tak pura sort kr denge
        // index 0 hote he hum Base case 2 pr chale jayenge
        if (si == li) {
            bsort(arr, 0, li - 1);
            return;
        }

        // STEP 1
        // The main thing in bubble sort is to compare adjacent elements and their swapping. We got 1 element at its right place after each iteration. Like this if we will sort last 4 elemnts out 5 , left 1 element will get its right postion automatically 
        if (arr[si] > arr[si + 1]) {
            int temp = arr[si];
            arr[si] = arr[si + 1];
            arr[si + 1] = temp;
        }

        // STEP 2
        // Increment si to compare all adjacent elements for completing the iteration
        bsort(arr,si+1,li);
    }
}
