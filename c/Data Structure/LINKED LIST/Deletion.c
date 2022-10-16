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

void delete(struct node *n,int num)
 {
    struct node* prev =malloc(sizeof(struct node));
    while(n!=NULL)
    {
        if(n->data==num)
            {
                prev->next=n->next;
            }
        prev=n;
        n=n->next;
    }
    free(n);
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

int main()
{
    int num,n,p; 
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
    printf("\nDelete which element : ");
    scanf("%d",&p);
    delete(head,p);
    printList(head);
    return 0;
}

