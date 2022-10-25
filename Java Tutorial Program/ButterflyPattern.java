//Code for Butterfly Pattern in java
import java.util.*;
public class pat5 {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows for pattern");
        int n=sc.nextInt();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            for (int k=1;k<=2*(n-i);k++){
                System.out.print(" ");

            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=n;i>=1;i--){
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            for (int k=1;k<=2*(n-i);k++){
                System.out.print(" ");

            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
    
}
