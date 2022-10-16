#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,t=0,n,sum=0;
    printf("enter number of elements\n");
    scanf("%d",&n);
    for (i=0;i<=n;i++)
    {
        sum=sum+t;
        t=(t*10)+1;
    }
    printf("%d",sum);
    return 0;
}
