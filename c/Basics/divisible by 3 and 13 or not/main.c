#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x;
    printf("ENter ur number");
    scanf("%d",&x);
    if((x%3==0)&&(x%13==0))
       printf("yes divisible by 3 and 13");
    else printf("no not divisible by 3 and 13");
    return 0;
}
