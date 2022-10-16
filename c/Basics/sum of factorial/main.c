#include <stdio.h>
#include <stdlib.h>
int factorial(int x)
{
    int fact=1;
    for (int i=1;i<x+1;i++)
    {
        fact=fact*i;
    }
    return fact;
}
int main()
{
    int sum=0;
    for (int i=1;i<5;i++)
    {
        sum=sum+factorial(i);
    }
    printf("the required sum is %d",sum+1);
    return 0;
}
