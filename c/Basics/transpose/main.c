
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,j,i;
    int A[10][10];
    printf("Enter dimension");
    scanf("%d", &n);
    printf("enter %d X %d Matrix :\n",n,n);
    for (i=0;i<n;i++)
        {
            for (j=0;j<n;j++){
                scanf("%d", &A[i][j]);
        }
    }
    printf("A=\n");
     for (i=0;i<n;i++){
        for (j=0;j<n;j++)
        {
                printf("%d\t", A[i][j]);
        }
        printf("\n");
     }
    printf("tA=\n");
     for (i=0;i<n;i++){
        for (j=0;j<n;j++)
        {
                printf("%d\t", A[j][i]);
        }
        printf("\n");
     }
    return 0;
}
