#include<stdio.h>
void Rank(int a[], int n, int r[])
{
int C=0;
for (int i=0;i<n;i++)
r[i]=0; //initialize rank array
for(int i=1;i<n;i++)
{
for (int j=0; j<i; j++)
{     C++;
if(a[j]<=a[i]) r[i]++;
else r[j]++;
 	}
}
printf(“Time complexity=%d”, C);
}
void Rearrange(int a[], int n, int r[])
{
int u[20];
for (int i=0;i<n;i++)
u[r[i]]=a[i];
for(int i =0;i<n;i++)
a[i]=u[i];

}

int main( )
{
	int a[100], n, i, r[100];
	
	printf(“Enter the value of n\n”);
	scanf(“%d”, &n);
  	printf(“ Enter %d integers\n”,n);
            for (i=0; i<n; i++)
	scanf(“%d”,&a[i]);
            
	Rank( a,  n,  r);
            Rearrange(a, n, r);
	printf(“The array elements after sorting are\n”);
	for (i=0; i<n; i++)
	printf(“%d\n”, a[i]);
return 0;
}
