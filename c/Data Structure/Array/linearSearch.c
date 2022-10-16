#include <stdio.h>
#include <stdlib.h>
//linear search
int linearSearch(int A[10],int n, int x)
{
    int i;
    for (i=0;i<n;i++)
    {
        if (x==A[i])
            return i;
    }
    return -1;
}
int main()
{
    int A[10];
    int n,x;
    printf("create a list of elements ");
    scanf("%d",&n);
    for (int i=0;i<n;i++)
    {
        scanf("%d",&A[i]);
    }
    printf("enter the number to search");
    scanf("%d",&x);
    int r= linearSearch(A,n,x);
    printf("the number %d is in index %d",x,r);
    return 0;
}
