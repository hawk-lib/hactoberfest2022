#include <stdio.h>
#include <stdlib.h>
/* swap(int *a,int *b)
{
    int temp=*a;
    *a=*b;
    *b=temp;
}*/
void reverse (int a[],int n)
{
    for (int i=0;i<n;i++)
        printf("%d ",a[i]);
}
int main()
{
    int a[100];
    int n,i;
    printf("enter size of array");
    scanf("%d",&n);
    printf("enter elements of array\n");
    for (i=0;i<n;i++)
        scanf("%d",&a[i]);
    reverse(a,n);
    printf("reverse array is\n");
    for (i=0;i<n;i++)
        printf("%d ",a[i]);
    return 0;
}
