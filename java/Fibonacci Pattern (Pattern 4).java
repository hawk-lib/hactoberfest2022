// 0
// 1 1
// 2 3 5
// 8 13 21 34
import java.util.*;
public class Main {
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
     int t1=0;
     int t2=1;
     int temp;
     for(int i=1;i<=n;i++){
         for(int j=1;j<=i;j++){
             System.out.print(t1+"\t");
             temp=t1+t2;
             t1=t2;
             t2=temp;
         }
         System.out.println();
     }
    }
}