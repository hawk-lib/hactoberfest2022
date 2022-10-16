#include <stdio.h>
#include <stdlib.h>
int det(int A[][10],int n);
int main()
{
    int n,i,j;
    int A[n][10],B[n][10],C[n][10];
    printf("enter order of matrix\n");
    scanf("%d",&n);
    printf("enter A");
    for (i=0;i<n;i++){
        for (j=0;j<n;j++){
        scanf("%d",&A[i][j]);}
    }
    printf(" A:\n");
    for (i=0;i<n;i++)
        {
        for (j=0;j<n;j++)
          {
              printf("%d",A[i][j]);
          }
        }
    printf("\n");

//find determinant
    int d;
    d=det(A,n);
    printf("det(A)=%d\n",d);

    //for cofactor
    for (i=0;i<n;i++){
        for (j=0;j<n;j++){
                //find submatrix
                for (i1=0;i1<n;i1++){
                    if (i1==i) continue;
                    for (j=0;j<n;j++){
                        if (j1==j) continue;
                        B[i2][j2]=A[i1][j1];
                        j2++
                    }
                    i2++
                }
            if ((i+j)%2==0)
            if ((i+j)%2==0)
                C[i][j]=det(B,n-1);
            else
                C[i][j]=-det(B,n-1)
        }
    }
}
int det(int A[][10],int n)
{
    int s=0,i1=0,j1,i,j;
    int B[n-1][10];


    for (int k=0;k<n;k++)
       {
           for (i=0;i<n;i++){
            j1=0;
            for (j=0;j<n;j++){
                if (j==k) continue;
                B[i1][j1]=A[i][j];
                j1++;
                   }
          i1++;
       }
        if (k%2==0)  s+=A[0][k]*det(B,n-1);
        else  s+=(-A[0][k])*det(B,n-1);
        }
  return s;
}
