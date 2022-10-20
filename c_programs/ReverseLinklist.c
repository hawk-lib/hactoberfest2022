#include<stdio.h>
#include<stdlib.h>

struct node
{
    struct node *link;
    int data;
}*head=NULL;

void create();
void display();
void reverse();

void main()
{
    int ch;
    printf("Select From menu : ");
    while(1)
    {
        printf("1.Create\n2.Display\n3.Reverse\n");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:create();
            break;
            case 2:display();
            break;
            case 3:reverse();
            break;
            case 4:exit(0);
            break;
        }
    }
}

void create()
{
    int n;
    struct node *temp,*next;
    
    printf("Enter number of nodes : ");
    scanf("%d",&n);
    printf("Enter Data in nodes : ");

    
    for(int i=0;i<n;i++)
    {
    next = (struct node *)malloc(sizeof(struct node));
    temp = (struct node *)malloc(sizeof(struct node));

    temp->link=NULL;
    next->link=NULL;

    scanf("%d",&temp->data);
    if(head==NULL)
    {
        head = temp;
    }
    else
    {
        next = head;
        while(next->link!=NULL)
        {
            next = next->link;        
        }
        next->link = temp;
    }
    }
}

void display()
{
    struct node *next;
    next = (struct node *)malloc(sizeof(struct node));
    
    next = head;
    while(next!=NULL)
    {
        
        printf("%d",next->data);
        next = next->link;
    }
}

void reverse()
{
    // |1|->|2|->|3|->|4|
    //  a    b    c
    struct node *a,*b,*c;
    a = head;
    b = a->link;
    c = b->link;

    a->link = NULL;
    b->link = a;
    while(c!=NULL)
    {
        a = b;
        b = c;
        c = c->link;
        b->link = a;
    }
   head = b;
}