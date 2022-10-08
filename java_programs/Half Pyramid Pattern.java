// 1 
// 1 2 
// 1 2 3 
// 1 2 3 4 
// 1 2 3 4 5
import java.util.*;
public class Main {
    public static void main (String args[]) {
      Scanner sc=new Scanner(System.in);
      int N=sc.nextInt();
      int row=1;
      int nst=1;
      int val=1;
      while(row<=N){
          int cst=1;
          int cval=val;
          while(cst<=nst){
             System.out.print(cval+" ");
             cst+=1;
             cval+=1;
          }
         
          row+=1;
          nst+=1;
          System.out.println();

      }
    }
}