// C program to implement recursive Binary Search
#include <stdio.h>

// A recursive binary search function
int binarySearch(int arr[], int left, int right, int search)
{
    if (right >= left) {
        int mid = left + (right - left) / 2;

        // If the element is present at the middle
        if (arr[mid] == search)
            return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr[mid] > search)
            return binarySearch(arr, left, mid - 1, search);

        // Element in right subarray
        return binarySearch(arr, mid + 1, right, search);
    }

    // Element not present in array
    return -1;
}

int main(void)
{
    int n=0;
    printf("Enter size of the array: ");
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++)
    {
        printf("Enter number: ");
        scanf("%d", &arr[i]);
    }

    int x;
    printf("Enter number to be searched: ");
    scanf("%d", &x);
    int result = binarySearch(arr, 0, n - 1, x);
    if(result == -1)
        printf("Element is not present in array");
    else printf("Element is present at index %d", result);
    return 0;
}
