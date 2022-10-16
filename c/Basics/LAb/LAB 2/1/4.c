#include <stdio.h>


int main()
{
    int a=2,b=9,c=3,d=5,p,q,x,y,j,k,o;
    p= !d && c;
    q= !d || c;
    x=a++ - ++a - a--;
    y=b++ - b-- + --b - b--;
    j=p&&q;
    k=x&&y;
    o=j>k;
    printf("O is %d",0);
    return 0;
}
