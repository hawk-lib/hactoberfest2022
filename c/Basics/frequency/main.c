#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char *s[1000];
    scanf("%s",s);
    int i,a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,j=0,k=0;
    for(i=0;i<12;i++)
    {
        if (s[i]==0) k=k+1;
        else if (s[i]==1) a=a+1;
        /*else if (s[i]==2) b++;
        else if (s[i]==3) c++;
        else if (s[i]==4) d++;
        else if (s[i]==5) e++;
        else if (s[i]==6) f++;
        else if (s[i]==7) g++;
        else if (s[i]==8) h++;
        else if (s[i]==9) j++;*/
    }
    printf(" %d",k);
    printf(" %d",a);
    /*printf(" %d",b);
    printf(" %d",c);
    printf(" %d",d);
    printf(" %d",e);
    printf(" %d",f);
    printf(" %d",g);
    printf(" %d",h);
    printf(" %d",j);*/



    return 0;
}
