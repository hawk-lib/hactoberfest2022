import java.util.Scanner;
class Average
{
    public static void main(String[] args) {
        
    
    Scanner input=new Scanner(System.in);
    int total;
    int gradeCounter;
    int grade;
    int average;
    total=0;
    gradeCounter=1;
    while(gradeCounter<=10)
    {
        System.out.print("enter grade");
        grade = input.nextInt();
        total=total+grade;
        gradeCounter=gradeCounter+1;
    }average=total/10;
    System.out.printf("\n total of all 10 grade is %d \n",total);
    System.out.printf("class average is %d \n",average);
    }
}
