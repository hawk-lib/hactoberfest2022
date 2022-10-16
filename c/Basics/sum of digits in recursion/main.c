#include<stdio.h>
#include<stdlib.h>
int main()
{
    int n,r,sum=0;
    printf("Enter n\n");
    scanf("%d",&n);
    while (n!=0)
        {
            r=n%10;
            sum=sum+r;
            n=n/10;
        }
        printf("%d",sum);
    return 0;
}
