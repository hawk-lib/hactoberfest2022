#include<bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    struct Node*next;
}*first=NULL;

void create(int A[], int n)
{
    int i;
    struct Node *t, *last;
    first =new Node;
    first->data = A[0];
    first->next = NULL;
    last = first;

    for (i = 1; i < n; i++)
    {
        t =new Node;
        t->data = A[i];
        t->next = NULL;
        last->next = t;
        last = t;
    }
}

void Display(struct Node *p)
{
    while (p != NULL)
    {
        printf("%d ", p->data);
        p = p->next;
    }
}


//Iterative way: Sliding pointers
// void rev()
// {
//     struct Node *p=first;
//     struct Node *q=NULL;
//     struct Node *r=NULL;
//     while(p!=NULL)
//     {
//         r=q;
//         q=p;
//         p=p->next;
//         q->next=r;
//     }
//     first=q;
// }

// Recursive way:
void rev(struct Node *curr)
{
    if(curr==NULL)
    {
        return;
    }
    if(curr->next==NULL)
    {
        first=curr;
        return ;
    }
    rev(curr->next);
    curr->next->next=curr;
    curr->next=NULL;
    
}
// struct Node*reverseList(Node*head){
//     Node*cur=head;
//     Node*prev=NULL;
//     while(cur){
//         Node* next=cur->next;
//         cur=prev;
//         prev=cur;
//         cur=next;
//     }
//     head=prev;
//     return head;
// }

int main()
{
    int A[] = {8, 5, 4, 7, 3, 9};
    create(A, 6);
    cout<<"Original List :\t";
    Display(first);
    // reverseList(first);
    cout<<"\n";
    cout<<"Reversed List :\t";
    rev(first);
    Display(first);
}
