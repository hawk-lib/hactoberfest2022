import java.util.Scanner;
class Array_element
{
    public static void main(String[] args) 
    {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in array:");
        n = s.nextInt();
        int a[] = new int[n];
        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) 
        {
            a[i] = s.nextInt();
        }
        System.out.print("Enter the k th position at which you want to check number:");
        int k = s.nextInt();
        System.out.println("Number:"+a[k-1]);
    }
}
