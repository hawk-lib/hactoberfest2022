import java.io.*;
import java.util.*;
public class kth_max_Min_element {
    public
    static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, k, i;

        System.out.println("Enter the size of the array: ");
        n = 3;

        System.out.println("Enter the elements for the array: ");
        int arr[] = {1,2,4,5};


        System.out.println("Enter the value of k: ");
        k = 2;

        PriorityQueue queue = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("Kth smallest element is: ");

        for (i = 0; i < n; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();  // top elements will be removed if size>k
            }
        }
        System.out.println(queue.peek());  // top will be printed

        PriorityQueue queue1 = new PriorityQueue<>();
        System.out.println("Kth Largest element is: ");

        for (i = 0; i < n; i++) {
            queue1.add(arr[i]);
            if (queue1.size() > k) {
                queue1.poll();  // top elements will be removed if size>k
            }
        }
        System.out.println(queue1.peek());  // top will be printed
    }
}
