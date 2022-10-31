// Convert To Binary
void ctb(int n){
    int i;
    for(i=31;i>=0;i--)
    {
        int m = 1 << i ;
        int k = n & m;
        k = k >> i ;
        printf("%d",k);
        if(i%4==0){
            printf(" ");
        }
    }
}
//vowel check

void vowel(char a)
{
     if(a=='a' || a=='e' || a=='i'|| a=='o' || a=='u')
     {
         printf("entered char %c is vowel",a);
     }
     else
     {
         printf("its a con");
     }
}
//alphabet check
void alphabet(char a)
{
    if((a>= 'a' || a>='A') && (a<= 'z' || a <= 'Z') )
    {
        printf("char is an alphabet");
    }
    else
    {
        printf("not an alphabet");
    }
}
//swap two numbers without a third variable
void swap(int* a,int* b)
{
    *a=*a+*b;
    *b=*a-*b;
    *a=*a-*b;
    
    printf("a = %d , b = %d \n",*a,*b);
}
//ascii value of an integer
void ascii(char s)
{
    printf("ascii of %c is %d",s,s);
}    

//find the number of digits in an integer
void count(int a)
{
    int count=0;
    while(a!=0)
    {
        a=a/10;
        count++;
    }
    printf(" count is %d",count);
}
// sum of digits
void sum(int n)
{
    int s=0;
    int m;
    while(n!=0)
    {
        m=n%10;
        s = s+m;
        n=n / 10;
    
    }
    printf("%d",s);
}
// reverse the number
void reverse(int n)
{
    int r=0;
    while(n!=0)
    {
    int m=n%10;
    r=(r*10)+m;
    n=n/10;
    }
    printf("%d",r);

} 
//sum of the number in a given range
void range(int a,int b)
{
    int s=0;
    int i;
    for(i=a;i<=b;i++)
    {
        s=s+i;

    }
    printf("%d",s);

}
//palindromint ne or not
// void palindrome(n)
// {
//     while(n !=0)
//     {

//     int m;
//      m=n%10;
//      n=n/10;

//    }
// }
// sum of natural numbers
 int n_sum(int n)
{
    while(n != 0)
    {
    return ( n + n_sum(n-1));

    }

}

//prime numbers
void prime(int n)
{
 int i;
   for(i=2;i<=n/2;i++)
   {
    if(i==1 || (n%i) == 0)
    {
        printf("%d primr",i);
    }
    else{
        printf("%d is nnot prime",i);
    }
  }
}
//cube of any
//int cube(int* n)
//{
   // int a;
   // a=*n * *n * *n;
   // return n;
//}

// prime bitween range
/*void prime_range(int a,int b)
{
   // int i;
    while(a<=b )
    {
       prime(a);
    
    }
    a++;
}*/

//natural numbers from 1 to n
int sumt(int n1,int n2)
{
   
   if(n1==n2)
    {
      return n1;
    }
    else
     
   {
    return (n1+sumt(n1++,n2));
   }
}
// inter change the bits
void interchange_bits(int p1,int p2,int n)
{
    int m,k,l,i,r;
    
   m= 1<<p1;
   k=m & n;
   l=1<<p2;
   i=l & n;
   r=k|i;
   for(i=8;i>0;i--)
   {
    printf("%d",((r>>i)&1));
   }
}
// min number of bits to store an integer
int min_bit (int n)
{
    printf("min\n");
    int i,c=0;
    for(i=31;i>=0;i--)
    {
         if((1<<i)&n)
        {
            c=i+1;
            return c;
        }
        
    }
}
//find the 1's in an integer
int count_1(int n)
{
   int i,count=0;
   for(i=32;i<0;i--)
   {
     if((1<<i)&n)
    {
       count=i+1;
    }
   }
   return count;
    
}
//little endian
int little_endian (int *n)
{
    


    if(*n==56)
    {
        printf("it is little endian");
    }
    else{
        printf("it is big endian");
    }

}
void array_value(int *ptr)
{
    int i;
    for(i=0;i<5;i++)
    {
        printf("%d element is %d\n",i,ptr[i]);
        //ptr++;
    }
}
//sturucture

 void count_p(char * ch)
 {
    int count=0;
    while(*ch != '\0')
    {
        count++;
        ch++;

    }
    printf("%d",count);

 }
int rev_num(int num){
    int revNum =0,remainder;
      while (num != 0){

        remainder = num % 10;

        revNum = revNum * 10 + remainder;

        num = num/10;
      }
    return revNum;
}

void odd_even(int num){
    // true if num is perfectly divisible by 2
    if(num % 2 == 0)
        printf("%d is even.", num);
    else
        printf("%d is odd.", num);
}
void print_factors(int num){
    printf("Factors of %d are: ", num);
    for (int i = 1; i <= num; ++i) {
        if (num % i == 0) {
            printf("%d ", i);
        }
    }
}
