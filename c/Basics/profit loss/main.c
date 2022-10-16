#include <stdio.h>
#include <stdlib.h>

int main()
{
    int profit,SP,CP;
    printf("Enter sell price");
    scanf("%d",&SP);
    printf("Enter cost price");
    scanf("%d",&CP);
    profit = SP-CP;
    printf("profit is %d", profit);
    return 0;
}
