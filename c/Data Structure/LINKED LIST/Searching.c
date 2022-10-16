#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};

void push(struct node *n,int num )
    {
    while(n->next!=NULL)
    {
        n=n->next;
    } 
    struct node* newNode;
    newNode=(struct node*)malloc(sizeof(struct node));
    newNode->data=num;
    newNode->next=NULL;
    n->next=newNode;
    }
void printList(struct node* n)
{
    int c=0;
    while (n != NULL) {
         if(c==0)//as there is no data in Head
            n = n->next;
        printf(" %d ", n->data);
        n = n->next;
        c++;
    }
}
int search(struct node* n,int num)
{
    int c=0;
    while (n != NULL) {
         if(n->data==num)//as there is no data in Head
           { printf("\nThe element is in position :%d ",c);
            return 0;
           }
        n = n->next;
        c++;
    }printf("not present");
}
int main()
{
    int num,n;
    struct node* head=malloc(sizeof(struct node));
    head->next=NULL;

    printf("enter size : ");
    scanf("%d",&n);
    
    for (int i=1;i<n+1;i++)
    {
        printf("enter element %d :",i);
        scanf("%d",&num);
        push(head,num);
    }
    printList(head);
    printf("\nWhich Element you want to search-- \n");
    scanf("%d",&num);
    search(head,num);
    return 0;
}

