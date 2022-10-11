#include <bits/stdc++.h>
using namespace std;
void print(int *array,int n)
{

for(int i=0;i<n;i++)
{
    cout<<array[i]<<" ";
}
}
void merge(int *array ,int left ,int mid,int right)
{
    int i, j, k, nl, nr;
    
    nl = mid - left + 1;
    nr = right - mid;
    int leftarray[nl], rightarray[nr];
    
    for (i = 0; i < nl; i++)
        leftarray[i] = array[left + i];
    for (j = 0; j < nr; j++)
        rightarray[j] = array[mid + 1 + j];
    i = 0;
    j = 0;
    k = left;

    while (i < nl && j < nr)
    {
        if (leftarray[i] <= rightarray[j])
        {
            array[k] = leftarray[i];
            i++;
        }
        else
        {
            array[k] = rightarray[j];
            j++;
        }
        k++;
    }
    while (i < nl)
    { 
        array[k] = leftarray[i];
        i++;
        k++;
    }
    while (j < nr)
    { 
        array[k] = rightarray[j];
        j++;
        k++;
    }


}
void sort(int * array,int left,int right)
{
     int mid;
    if (left < right)
    {
        int mid = left + (right - left) / 2;
    
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

}
int main()
{
    cout<<"enter the size of the array"<<endl;
    int n;
    cin>>n;
    int arr[n]={};
    cout<<"Enter the elements in the array "<<endl;
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    cout<<"sorted array"<<endl;
    sort(arr,0,n-1);
    print(arr,n);
    return 0;
}