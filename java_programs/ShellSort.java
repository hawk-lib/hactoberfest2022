class ShellSort {
    /*
        Code: Shell Sorting Algorithm 
        Name: Abhishek Dharmik 
        Last Modified on: 02 October, 2022   
     */
    
    public static void main(String args[]) {
        int arr[] = {12, 34, 54, 2, 3};
        ShellSort ob = new ShellSort();
        ob.sort(arr);
        System.out.println("Sorted Array: ");
        printArray(arr);
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
  
    int sort(int arr[]) {
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        return 0;
    }
} 
