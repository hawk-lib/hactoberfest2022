#include <stdio.h>
#include <stdlib.h>
void swap(int *a,int *b)
{
    int temp=*a;
    *a=*b;
    *b= temp;
}
int main()
{
    int a[100],b[100];
    int n,i;
    printf("enter size of array");
    scanf("%d",&n);
    printf("enter elements of array 1\n");
    for (i=0;i<n;i++)
        scanf("%d",&a[i]);
    printf("enter elements of array 2\n");
    for (i=0;i<n;i++)
        scanf("%d",&b[i]);
    for (i=0;i<n;i++)
        swap(&a[i],&b[i]);
    printf("now array 1 is\n");
    for (i=0;i<n;i++)
        printf("%d ",a[i]);
    printf("\n");
    printf("now array 2 is\n");
    for (i=0;i<n;i++)
        printf("%d ",b[i]);
    return 0;
}
