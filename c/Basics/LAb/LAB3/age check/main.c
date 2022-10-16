#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x;
    printf("enter ur age");
    scanf("%d",&x);
    if (x>=18)
        printf("Congratulations! You are eligible for casting your vote");
    else printf("sorry try after being 18");

    return 0;
}
