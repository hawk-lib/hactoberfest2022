#include<stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node *next;
    struct node *prev;
};
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
    struct node *node1=malloc(sizeof(struct node));
    struct node *node2=malloc(sizeof(struct node));
    struct node *node3=malloc(sizeof(struct node));
    struct node *head=malloc(sizeof(struct node));
    
    head->next=node1;
    head->prev=NULL;
    
    node1->next=node2;
    node1-> data= 3;
    node1->prev=head;
    
    node2->next=node3;
    node2-> data= 4;
    node2->prev=node1;
    
    node3->next=NULL;
    node3-> data= 5;
    node3->prev=node2;


    printList(head);

}