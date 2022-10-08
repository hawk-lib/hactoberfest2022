import java.util.*;  
public class Tribonacci
{  
public static void main(String args[])  
{  
Scanner sc = new Scanner(System.in);  
System.out.print("Enter No. of terms: ");  
int n=sc.nextInt();  
int a = 1, b = 0, c = 1;  
int d = a + b + c;  
System.out.println("\nTribonacci Series: ");  
System.out.print(a+"\t"+b+"\t"+c);  
for(int i=4; i<=n; i++)  
{  
System.out.print("\t"+d);  
a=b;  
b=c;  
c=d;  
d=a+b+c;  
}  
System.out.println();  
}  
}  
