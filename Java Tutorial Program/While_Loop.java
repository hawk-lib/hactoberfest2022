import java.util.*;
class While_Loop
{
    public static void main(String[] args) 
    {
        int num, temp, reverse = 0, rightDigit;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        num = in.nextInt();
        temp = num;
        while(temp != 0)
        {
            rightDigit = temp % 10;
            reverse = reverse*10 + rightDigit;
            temp = temp/10;
        }
        if(reverse == num)
          System.out.print(num + " is Palindrome number");
        else 
          System.out.print(num + " is not a Palindrome number");
    }
}
