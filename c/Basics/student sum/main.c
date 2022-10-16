#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,sum=0;
    int marks[10];
    char gender;
    scanf("%c",&gender);

    scanf("%d",&n);
    for (int i=0;i<n;i++)
    {
        scanf("%d",&marks[i]);
    }

    if (gender=='b')
    {
        for (int i =0;i<3;i++)
            sum=sum+marks[2*i];
    }
    else
    {
        for(int i=0;i<5;i++)
        sum=sum+marks[2*n+1];
    }
    printf("%d",sum);


    return 0;
}
