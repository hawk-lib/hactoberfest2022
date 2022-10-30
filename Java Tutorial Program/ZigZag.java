import java.io.*;
import java.util.*;

public class ZigZag {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    pzz(n);
  }

  public static void pzz(int n) {
    if(n == 0){
      return;
    }
    
    System.out.print(n + " ");
    pzz(n - 1);
    System.out.print(n + " ");
    pzz(n - 1);
    System.out.print(n + " ");
  }

}


                        
                                