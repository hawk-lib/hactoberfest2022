#include <stdio.h>
#include <stdlib.h>

int main()
{
    int dis,price;
    char type;
    price=0;
    printf("Enter type");
    scanf("%s",&type);
    printf("Enter distance");
    scanf("%d",&dis);
    if (type=='m')
        {price=15*dis;
        printf("%d",price);
        }
    else if (type=='M')
        {price= 20*dis;
         printf("%d", price);}
    else if (type=='S')
        {price=25*dis;
        printf("%d", price);}
    printf("%d",price);
    return 0;
}
