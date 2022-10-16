#include <stdio.h>
#include <stdlib.h>
int maximum(int n1, int n2) {
    if (n2 != 0)
        return maximum(n2, n1 % n2);
    else
        return n1;
}
int main()
{
    int a ,b,max=0;
    printf("Enter larger number\n");
    scanf("%d",&a);
    printf("Enter smaller number\n");
    scanf("%d",&b);
    int m= maximum(a,b);
    printf("%d",m);

    return 0;
}
