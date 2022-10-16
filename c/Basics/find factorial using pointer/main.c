#include <stdio.h>
#include <stdlib.h>
int factorial(int *p)
{
    int fact=1;
    for (int i=1;i< *p+1;i++)
    {

        fact=fact*i;
    }
    return fact;
}
int main()
{
    int n;
    printf("Enter a number ");
    scanf("%d",&n);
    printf("%d ",factorial(&n));
    return 0;
}
