#include <stdio.h>

int main()
{ 
    int num;
    printf("Enter the numbers : \n");
    scanf("%d", &num);
    int multiply=1;

    for (int i= 1; i <= num; i++)
    {
        multiply=multiply*i;
       
    }
    
        printf("Factorial is : %d\n", multiply);
   
    return 0; 
}
