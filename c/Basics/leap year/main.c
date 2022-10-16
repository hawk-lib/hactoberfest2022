#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x;
    printf("ENter year");
    scanf("%d",&x);
    if (x%4==0)
        printf("leap year");
    else printf("not a leap year");
    return 0;
}
