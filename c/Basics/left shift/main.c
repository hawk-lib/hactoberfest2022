#include <stdio.h>
#include <stdlib.h>
void cal(int a);
int main()
{
    int x=1;
    cal(x+10);
    return 0;
}
void cal(int a)
{
    a=a<<1;
    printf("%d",a);

}
