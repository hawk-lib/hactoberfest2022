#include <stdio.h>
#include <stdlib.h>
void enter(int X[][10],int n,int m);
void display(int X[][10],int n,int m);
void add(int X[][10],int Y[][10],int Z[][10],int n,int m);

int main()
{
    int n,m;
    //m rows n columns
    int X[m][n],Y[m][n],Z[m][n];
    printf("enter matrix size");
    scanf("%d %d",&m,&n);
    printf("enter x\n");
    enter(X,n,m);
    printf("enter y\n");
    enter(Y,n,m);
    printf("X=\n");
    display(X,n,m);
    printf("Y=\n");
    display(Y,n,m);
    add(X,Y,Z,n,m);
    printf("z=X+Y=\n");
    display(Z,n,m);
    return 0;
}
void enter(int X[][10],int n,int m)
{
    int i,j;
    for(i=0;i<m;i++)
        {
            for (j=0;j<n;j++)
                {
                    scanf("%d",&X[i][j]);
                    }
        }
}
void display(int X[][10],int n,int m)
{
    int i,j;
    for(i=0;i<n;i++)
    {
        for (j=0;j<n;j++){

           printf("%d ",X[i][j]);}
    printf("\n");
    }
    printf("\n");
}

void add(int X[][10],int Y[][10],int Z[][10],int n,int m)
{
    int i,j;
     for(i=0;i<n;i++)
        {
            for (j=0;j<n;j++)
            Z[i][j]=X[i][j]+Y[i][j];
     }
}
