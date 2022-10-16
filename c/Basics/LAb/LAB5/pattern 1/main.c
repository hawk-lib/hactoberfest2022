#include <stdio.h>
#include <stdlib.h>

int main()
{
   int i ,k, j;
   for (i=0;i<=3;i++)
   {
        for (k=0;k<=4-i;k++)
        {
            printf(" ");
        }

        for(j=0;j<i+1;j++)
        {
          printf("* ");
        }
printf("\n");
   }
    return 0;
}
