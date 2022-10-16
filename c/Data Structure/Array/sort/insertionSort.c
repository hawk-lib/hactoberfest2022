#include <math.h>
#include <stdio.h>

void printArray(int arr[], int n)
{
	int i;
	for (i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

void insertionSort(int arr[], int n)
{
	int i, key, j;
	for (i = 1; i < n; i++) {
		key = arr[i];
		j = i - 1;

		/* Move elements of arr[0..i-1], that are
		greater than key, to one position ahead
		of their current position */
		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = key;
        printf("PASS %d :",i); 
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
    insertionSort(A,n);
    printf("final sorted array is: ");
    printArray(A,n);
}

