import java.util.Arrays;
public class Cyclesort{
	public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 1,4 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // time complexity for cycle sort O(n)
    /*
     * when given nos. from range 1 to N => use cyclic sort
     */
    static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}
