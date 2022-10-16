#include <stdio.h>
#include <stdlib.h>
int add(int *b,int *a)
{
    return *a+*b;
}
int main()
{
    int n;
    printf("Enter size of matrix");
    scanf("%d",&n);
    int a[n][n],b[n][n];
    printf("enter matrix A\n");
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }
    printf("enter matrix B\n");
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            scanf("%d",&b[i][j]);
        }
    }
    int c[n][n];
    printf("sum =\n");
    for (int i=0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
            c[i][j]= add(&a[i][j],&b[i][j]);
            printf("%d ",c[i][j]);
        }
        printf("\n");
    }
    return 0;
}
