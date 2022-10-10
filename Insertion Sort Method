import java.util.*;
public class InsertionSort
{
    void sort(int arr[])//Sorting the Array
    {
        int n=arr.length;
        for(int i=1;i<n;++i)
        {
            int key=arr[i];
            int j=i-1;            
            while(j>=0&&arr[j]>key)
            {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    void printArray(int arr[])//Printing the Array
    {
        int n=arr.length;
        for(int i=0;i<n;++i)        
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    void main()//Inputting the value and passing it to the coerresponding Function
    {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
        for(int p=0;p<arr.length;p++)
        {
            System.out.println("Enter the Element to placed at["+p+"]:");
            arr[p]=sc.nextInt();
        }
        System.out.println("Given Array");
        printArray(arr);
        InsertionSort ob=new InsertionSort();
        ob.sort(arr);
        System.out.println("Sorted Array");
        printArray(arr);
    }
}
