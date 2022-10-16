#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[100];
    int x=0,y=999999999,n;
    printf("enter no. of elements");
    scanf("%d",&n);
    printf("enter elements of array");
    for (int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for (int i=0;i<n;i++)
    {
        if (a[i]>x)
            x=a[i];

        else if (a[i]<y)
            y=a[i];
    }
    printf("%d is max and %d is min",x,y);
    return 0;
}
