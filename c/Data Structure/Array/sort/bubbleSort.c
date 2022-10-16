#include <stdio.h>
#include <stdlib.h>
void sort(int A[],int n)
{
    int temp;
    for (int j=0;j<n;j++)
    {
    for (int i=0;i<n-j-1;i++)//as last j terms will be sorted after every pass
    {
       if (A[i] > A[i+1])
       {
           temp=A[i];
           A[i]=A[i+1];
           A[i+1]=temp;
       }printf("pass %d  ",j+1);
    PrintArray(A,n);
    printf("\n");

    }
    
    
    }
    printf("Final array");
    PrintArray(A,n);
    
}
void PrintArray(int arr[],int n){
    for (int i=0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }
}
int main()
{
    int A[100];
    int n;
    printf("enter how many no.s to be sorted");
    scanf("%d",&n);
    for (int i=0;i<n;i++)
    {
        scanf("%d",&A[i]);
    }
    printf("your sorted numbers in ascending order:\n");
    sort(A,n);
}
