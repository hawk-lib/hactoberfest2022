#include<stdio.h>
int stack[100],top,x,n;
int main()
{
    int n,opt;
    printf("enter size of stack");
    scanf("%d",&n);
    int stack[n];
    for (int i=0;i<n;i++)
    {
        scanf("%d",&stack[i]);
    }
    label:
    printf("If you want to PUSH press 0 \n to POP press 1 \n  to exit press 2");
    scanf("%d",&opt);
    if (opt==0)
    {
        push();
    }
    else if (opt==1)
    {
        pop();
    }
    goto label;
}    

void push()
{
    if(top>=n-1)
    {
        printf("\n\tSTACK is over flow");
        
    }
    else
    {
        printf(" Enter a value to be pushed:");
        scanf("%d",&x);
        top++;
        stack[top]=x;
    }
}
void pop()
{
    if(top<=-1)
    {
        printf("\n\t Stack is under flow");
    }
    else
    {
        printf("\n\t The popped elements is %d",stack[top]);
        top--;
    }
}
void print()
{
    if(top>=0)
    {
        printf("\n The elements in STACK \n");
        for(int i=top; i>=0; i--)
            printf("\n%d",stack[i]);
        printf("\n Press Next Choice");
    }
    else
    {
        printf("\n The STACK is empty");
    }
   
}