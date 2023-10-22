#include <stdio.h>
#include<stdlib.h>
typedef struct dnode
{
    int data;
    struct dnode *next, *prev;
}dnode;
int main() {
    dnode *head,*p,*q; int i,n;
    printf("enter size\t");
    scanf("%d",&n);
    head=(dnode *)malloc(sizeof(dnode));
     printf("enter head\t");
    scanf("%d",&head->data);
    head->next=NULL;
    head->prev=NULL;
    p=head;
    for(i=1;i<=n-1;i++)
    {
        q=(dnode *)malloc(sizeof(dnode));
        printf("enter other elements");
        scanf("%d",&q->data);
        q->prev=p;
        p->next=q;
        q->next=NULL;
        p=p->next;
    }
  q=head;
    while(q!=NULL)
    {
        printf("%d  \t",q->data);
        q=q->next;
    }
 printf("\n");

    //....
    printf("loc");
    int loc;
    scanf("%d ",&loc);
    p=head;
for(int i=1;i<=loc-2;i++)
{ 
    p=p->next;
    
}
 q = p->next;
   
    if (q->next != NULL) {
        q->next->prev=p;
         p->next = q->next;
    }
    else{
        p->next=NULL;
    }
    free(q);

q=head;
  while(q!=NULL)
    {
        printf("%d\t",q->data);
        q=q->next;
    }
  return 0;
}