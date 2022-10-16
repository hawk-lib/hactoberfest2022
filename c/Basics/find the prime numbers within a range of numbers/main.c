#include <stdio.h>
#include <stdlib.h>


int main()
{
    int i,j,r;
    printf("whats the range to find prime numbers?");
    scanf("%d",&r);
    for (i=2;i<=r;i++){
        if (prime(i)){
        printf("%d \n",i);
        }
    }
    return 0;
}
int prime(int i)
{

    int j;
    for (j=2;j<i;j++) {
            if (i%j==0) return 0;}
    return 1;

}
