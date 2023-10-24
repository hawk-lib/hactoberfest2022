#include <stdio.h>
#include <conio.h>
#define size 100
int partition(int a[], int beg, int end);
void quick_sort(int a[], int beg, int end);
void main()
{
    int arr[size], i, n;
    printf("\n Enter the number of elements in the array: ");
    scanf("%d", &n);
    printf("\n Enter the elements of the array: ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    quick_sort(arr, 0, n - 1);
    printf("\n The sorted array is: \n");
    for (i = 0; i < n; i++)
        printf(" %d\t", arr[i]);
    getch();
}
int partition(int a[], int beg, int end)
{
    int left, right, temp, loc, flag;
    loc = left = beg;
    right = end;
    flag = 0;
    while (flag != 1)
    {
        while ((a[loc] <= a[right]) && (loc != right))
            right--;
        if (loc == right)
            flag = 1;
        else if (a[loc] > a[right])
        {
            temp = a[loc];
            a[loc] = a[right];
            a[right] = temp;
            loc = right;
        }
        if (flag != 1)
        {
            while ((a[loc] >= a[left]) && (loc != left))
                left++;
            if (loc == left)
                flag = 1;
            else if (a[loc] < a[left])
            {
                temp = a[loc];
                a[loc] = a[left];
                a[left] = temp;
                loc = left;
            }
        }
    }
    return loc;
}
void quick_sort(int a[], int beg, int end)
{
    int loc;
    if (beg < end)
    {
        loc = partition(a, beg, end);
        quick_sort(a, beg, loc - 1);// right to left
        quick_sort(a, loc + 1, end); // left to right
    }
}
