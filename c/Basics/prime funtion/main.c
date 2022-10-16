#include <stdio.h>
#include <stdlib.h>
int prime(int x);
int main()
{
    int x;printf("enter x"); scanf("%d",& x);
    if (prime(x)) printf("prime ");
    else
        printf("non prime");
    return 0;
}

int prime(int x)
{
   for (int i=2;i*i<x;i++)
    if ((x%i)==0) return 0;

return 1;
}

