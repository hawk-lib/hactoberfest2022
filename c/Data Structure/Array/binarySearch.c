#include <stdio.h>
#include <stdlib.h>
//Binary search without recursion
int BinarySearch(int A[10],int n,int x)
{
    int start =0;
    int end=n-1;
    while(end>=start)
    {
        int mid=((start+end)/2);
        if (A[mid]==x) return mid;
        else if(A[mid]>x) end=mid-1;
        else start = mid+1;
    }
    return -1;
}
//using recursion
int recursiveBinarySearch(int A[], int start, int end, int x)
{
   if (end>= start){
      int mid= (start + end)/2;
      if (A[mid] == x)
         return mid;
      else if (A[mid]>x)
         return recursiveBinarySearch(A,start, mid-1, x);
      else return recursiveBinarySearch(A, mid+1, end, x);
   }
   return -1;
}




void sort(int A[10],int n)
{
    int temp;
    for (int j=0;j<n;j++)
    {
        for (int i=0;i<n;i++)
        {
            if (A[i] > A[i+1])
            {
                temp=A[i];
                A[i]=A[i+1];
                A[i+1]=temp;
            }
        }
    }

}




int main()
{
    int A[10];
    int n,x;
    printf("create a list of elements  ");
    scanf("%d",&n);
    for (int i=0;i<n;i++)
    {
        scanf("%d",&A[i]);
    }
    printf("enter the number to search");
    scanf("%d",&x);
    sort(A,n);
    int r= BinarySearch(A,n,x);
    int r2=recursiveBinarySearch(A,0,n-1,x);
    printf("\n the number is in index %d ",r);
    printf("\n the number is in index %d using recursion",r2);
    return 0;
}

