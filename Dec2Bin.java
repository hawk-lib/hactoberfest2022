// Converting a decimal number into binary in Java using while loop.
// By Soham Gupta (http://github.com/gupta-soham/) (https://www.linkedin.com/in/soham-gupta-in/)
public class Dec2Bin {
    public static void decToBin(int n){
        int Num = n;
        int pow = 0;
        int biNum = 0;
        while(n > 0){
            int rem = n % 2;
            biNum = biNum + (rem * (int)Math.pow(10, pow)); 
            pow++;
            n /= 2;
        }
        System.out.println("Binary form of " + Num + " = " + biNum);
    }    

    public static void main(String[] args) {
        decToBin(15);
    }
}
