#include<stdio.h>
int main()
{
    int A,pos_in_A ,pos_dec_A ,pre_in_A ,pre_dec_A;
    printf("enter var A");
    scanf("%d", &A);
    pre_in_A = ++A;
    pos_in_A = A++;
    pre_dec_A = --A;
    pos_dec_A = A--;
    printf("postfixincement %d \n",pos_in_A);
    printf("prefix incrment %d \n",pre_in_A);
    printf("postfixdecrement %d \n" ,pos_dec_A);
    printf("prefix decrement %d \n",pre_dec_A);
    return 0;

}
