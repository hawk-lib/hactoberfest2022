#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x;
    printf("enter a number");
    scanf("%d",& x);
    if (x%2==0) printf("its even number");
    else printf("it is odd number");
    return 0;
}
