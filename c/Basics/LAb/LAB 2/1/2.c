#include <stdio.h>


int main()
{
    int z;
    int x,y;
    x=10;
    y=15;
    z= x++ - ++y + ++x - y++ - x++;
    printf("Z is %d", z);
    return 0;
}
