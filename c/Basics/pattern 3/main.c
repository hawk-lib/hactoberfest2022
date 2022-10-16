
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    printf("Enter n");
    scanf("%d",&n);
    for (int i=n;i>0;i--){
        for (int j=n;j>0;j--){
            if (j<i)
                printf("%d ",i);
            else printf("%d ",j);}
        for (int k=2;k<n+1;k++)
        {
            if (k<i)
                printf("%d ",i);
            else printf("%d ",k);
        }


        printf("\n");
    }
    for (int i=2;i<n+1;i++)
        {
            for (int j=n;j>0;j--)
        {
            if (j>i)
                printf("%d ",j);
            else printf("%d ",i);
        }
            for (int k=2;k<n+1;k++)
            {
                if (i>k)
                    printf("%d ",i);
                else printf("%d ",k);
            }
        printf("\n");
        }

    return 0;
}
