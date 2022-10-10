#include<stdio.h>
#include<math.h>
int fib();
int main()
{int n;
 printf("Enter The No. Of Terms Of Fibonnaci");
 scanf("%d",&n);
 printf("%d \n",fib(n));
 return 0;
}
int fib(int n)
{   if(n==0)
    return 0;
    else if(n==1)
    return 1;
    int Fib = fib(n-2)+fib(n-1);
    return Fib;
}
