#include<iostream>
#include<algorithm>

using namespace std;
void display(int *array, int arraysize)
{
   for(int i = 1; i<=arraysize; i++)
      cout << array[i] << " ";
   cout << endl;
}
int getMax(int array[], int arraysize) {
   int max = array[1];
   for(int i = 2; i<=arraysize; i++) {
      if(array[i] > max)
         max = array[i];
   }
   return max; //the max element from the array
}
void countSort(int *array, int arraysize) 
{
   int output[arraysize+1];
   int max = getMax(array, arraysize);
   int count[max+1];

   for(int i = 0; i<=max; i++)
      count[i] = 0;     
   for(int i = 1; i <=arraysize; i++)
      count[array[i]]++;     
   for(int i = 1; i<=max; i++)
      count[i] += count[i-1];    
   for(int i = arraysize; i>=1; i--)
   {
      output[count[array[i]]] = array[i];
      count[array[i]] -= 1; 
   }
   for(int i = 1; i<=arraysize; i++) {
      array[i] = output[i]; 
   }
}
int main(){
   int n;
   cout << "Fistly enter the no. of elements: ";
   cin >> n;
   int arr[n+1];
   cout << "Now enter elements: " << endl;
   for(int i = 1; i<=n; i++){
      cin >> arr[i];
   }
   cout << "Before Sorting: ";
   display(arr, n);
   countSort(arr, n);
   cout << "After Sorting: ";
   display(arr, n);
}
