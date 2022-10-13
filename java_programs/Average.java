import java.util.Scanner;
public class Average {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] a = new int[10];
            int sum = 0;
            System.out.print("The numbers of elements :");
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter the " + i + " number : ");
                a[i] = sc.nextInt();
                sum = sum + a[i];
            }
            float avg = (sum / n);
            System.out.println("The average is : " + avg);
  }  }  }