#include <stdio.h>
#include <stdlib.h>

int main()
{
    int j,r;
    printf("Enter range for armstrong");
    scanf("%d",&r);
    for (j=0;j<=r;j++){
        if (amstrong(j)) printf("%d\n", j);

    }
   printf("\n");
   return 0;


}

int amstrong(int j)
{
   int d,p,sum=0,i;
   p = j;
   while (p!=0)
    {
     d=p%10;
     sum = sum+(d*d*d);
        p=p/10;
    }
     if (sum==j)  return 1;
    else return 0;
}

