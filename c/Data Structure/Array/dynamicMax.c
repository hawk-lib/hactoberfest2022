#include <stdio.h>
#include <stdlib.h>

int main(){
int num, *arr, i;
    printf("enter size of array");
    scanf("%d", &num);
    printf("enter array");
    arr = (int*) malloc(num * sizeof(int));
    for(i = 0; i < num; i++) {
        scanf("%d", arr + i);}
     int max=0;
     for (i=0;i<num;i++){
        if (arr[i]>max) max=arr[i];
     }
     printf(" max element is %d",max);
}
