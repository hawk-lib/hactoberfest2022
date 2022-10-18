import java.util.Scanner;
public class Largest_no {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int num1 = s1.nextInt();
        int num2 = s1.nextInt();
        int num3 = s1.nextInt();
        int max = 0;
        if (num1>num2){
            max = num1;
        }
else{
    max = num2;
        }
if (num3>max){
    max = num3;
}
        System.out.println(max);
    }
}
