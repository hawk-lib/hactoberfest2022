#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
   char sen[100];
   scanf("%[^\n]%*c",&sen);
   printf("%s",sen);
   return 0;
}
