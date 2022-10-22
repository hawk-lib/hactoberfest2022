#include <stdio.h>
#include <conio.h>
int selection(int[],int);
int main()
{
	int n,j,ptr[10];
	printf("enter n");
	scanf("%d",&n);
	printf("enter numbers");
	for(j=0;j<n;j++)
	{
		scanf("%d",&ptr[j]);
	}
	selection(ptr,n);
}
int selection(int ptr[10],int n)
{
	int f,i,k,temp,min;
	for(i=0;i<n-1;i++)
	{
		min=i;
		for(k=i+1;k<n;k++)
		{
			if(ptr[k]<ptr[min])
			{
				min=k;
			}
		}
		temp=ptr[min];
		ptr[min]=ptr[i];
		ptr[i]=temp;
	}
	printf("sorted array is\t");
	for(f=0;f<n;f++){
	printf("%d\t",ptr[f]);
}
}
