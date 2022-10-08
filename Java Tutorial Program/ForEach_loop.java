import java.util.*;

class ForEach_loop
{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    double numbers[] = new double[10];
    
    for (int i = 0; i < numbers.length; i++)
    {
        System.out.println("Please enter number : ");
        numbers[i] = input.nextDouble();
    }
    
    for (double number: numbers){
    System.out.println(number);
    }
  }

}
