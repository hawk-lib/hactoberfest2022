  #include <stdio.h>
#include <stdlib.h>

int main()
{
    int dist_1, dist_2,dist_3,km,m,km1,km2,m1,m2;
    printf("Enter your distance 1\n");
    scanf("%d",&dist_1);
    printf("Enter your distance 2\n");
    scanf("%d",&dist_2);
    dist_3=dist_1+dist_2;

    km=dist_3/1000;
    m=dist_3%1000;

    km1=dist_1/1000;
    m1=dist_1%1000;

    km2=dist_2/1000;
    m2=dist_2%1000;

    printf("%d km:",km1);
    printf("%d m",m1);
    printf("+ %d km:",km2);
    printf("%d m",m2);
    printf("= %d km:",km);
    printf("%d m",m);
        return 0;
}
