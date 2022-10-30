# include<stdio.h>
# include<string.h>
int main()
{
    char A[20],B[20];
    int i,s,j;
    printf("enter the string: ");
    /*scanf("%[^\n]s",A);*/
    fflush(stdin);
    gets(A);
    s=strlen(A);
    for(i=s-1,j=0;i>=0;j++,i--)
    {
        B[j]=A[i];
    }
    B[s]='\0';
if(strcmp(A,B)==0)
{
    printf("the string  is a palindrome");

} 
else
{
    printf("the string is not a palindrome");
    
}
return 0;
}

