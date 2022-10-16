#include <stdio.h>
#include <stdlib.h>

int main()
{
   int num;
   printf("enter an integer");
   scanf("%d", &num);
   printf("Squares of all numbers upto \n");
   for (int i=1;i<=num;i++)
   {
       printf("%d \t",(i*i) );
   }
   printf("\n");
}

