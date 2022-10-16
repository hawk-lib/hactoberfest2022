#include <stdio.h>
#include <stdlib.h>

int main()
{
    char X;
    printf("ENte an alphabet");
    scanf("%c", & X);
    if  (X=='a' ||X=='i' ||X=='o' ||X=='u' ||X=='e')
        printf("it is an vowel");
    else printf("it is a consonant");
    return 0;
}
