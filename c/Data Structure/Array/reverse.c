#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Enter n");
    int n,x=0,k,f=0;
    scanf("%d",&n);
    while (n>0)
    {
        k=n%10;
        x=x*10+k;
        if (x==0)
            printf("0");
        n=n/10;
    }
    printf("%d",x);
    return 0;
}
