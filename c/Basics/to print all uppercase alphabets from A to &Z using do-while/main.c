#include <stdio.h>
#include <stdlib.h>

int main()
{
    char ch='A';
    do
    {
        printf("%c \t",ch);
        ch++;
    }
    while (ch<='Z');
    return 0;
}
