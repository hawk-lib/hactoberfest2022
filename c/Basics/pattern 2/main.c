#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,j,k;
    for (i=0;i<5;i++)
    {
        for (j=1;j<=4-i;j++)
            printf(" ");
        for (k=0;k<(2*i-1);k++)
            printf("*");
        printf("\n");
    }
    for (i=4;i>0;i--)
    {
        for (j=0;j<=4-i;j++)
            printf(" ");
        for (k=3;k<=(2*i-1);k++)
            printf("*");
            printf("\n");
    }
    return 0;
}
