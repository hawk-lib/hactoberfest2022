#include <stdio.h>
#include <stdlib.h>

int main()
{
   int i,j;
   int C[3][3];
   for (i=0;i<3;i++)
   {
       for (j=0;j<3;j++)
       {
           scanf("%d",&C[i][j]);
       }
   }
   printf("%d",C[3][3]);
    return 0;
}
