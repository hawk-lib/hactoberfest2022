#include <stdio.h>
 
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}
/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
 
 
void selectionSort(int arr[], int n)
{
    int i, j, min_idx;
 
    // One by one move boundary of unsorted subarray
    for (i = 0; i < n-1; i++)
    {
        // Find the minimum element in unsorted array
        min_idx = i;
        for (j = i+1; j < n; j++)
          {
            if (arr[j] < arr[min_idx])
            min_idx = j;
          }
 
        // Swap the found minimum element with the first element
           if(min_idx != i)
            swap(&arr[min_idx], &arr[i]);
            printf("pass %d : ",i+1);
            printArray(arr,n);
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
    selectionSort(A,n);
    printf("final sorted array is: ");
    printArray(A,n);
}