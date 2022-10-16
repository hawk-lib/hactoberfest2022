#include <stdio.h>


int main()
{
    int a,b,c,d;
    c=1;
    d=2;
    a= !c && d;
    b= !c || d;
    printf("a AND b is %d", a && b);
    return 0;
}
