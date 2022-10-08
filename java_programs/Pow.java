// find n to the power m;
import java.util.*;
class Pow{
    public static int pow(int n,int m){
        if(m==0)return 1;
        return n * pow(n,m-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(pow(n,m));
    }
}
