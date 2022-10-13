import java.util.Scanner;

class Sumavgpro {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3, sum;
        float avg, prod;
        System.out.println("enter the first number:");
        n1 = sc.nextInt();
        System.out.println("enter the second number:");
        n2 = sc.nextInt();
        System.out.println("enter the third number:");
        n3 = sc.nextInt();
        sum = n1 + n2 + n3;
        avg = sum / 3;
        prod = n1 * n2 * n3;
        System.out.println("sum is" + sum + ",average is" + avg + ",product is" + prod);
        if (n1 > n2 && n1 > n3)
            System.out.println("the largest number is" + n1);
        else if (n2 > n3)
            System.out.println("the largest number is" + n2);
        else
            System.out.println("the largest number is" + n3);
    }
}
