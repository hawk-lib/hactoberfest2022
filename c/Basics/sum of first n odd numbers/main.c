#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,sum=0;
    printf("enter n");
    scanf("%d",&n);
    for (int i=1;i<2*n;i=i+2){
        sum=sum+i;
    }
    printf("%d",sum);
    return 0;
}
