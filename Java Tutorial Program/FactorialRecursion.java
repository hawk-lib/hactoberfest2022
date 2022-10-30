import java.io.*;
import java.util.*;

public class FactorialRecursion {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int f = factorial(n);
    System.out.println(f);
  }

  public static int factorial(int n) {
    if(n == 0){
      return 1;
    }
    int fm1 = factorial(n - 1);
    int f = fm1 * n;
    return f;
  }

}


                        
                                