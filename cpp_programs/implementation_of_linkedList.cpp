#include <iostream>
#include <bits/stdc++.h>
using namespace std;
// Implementation of Linked List in Cpp
class Node
{
public:
    int data;
    Node *link;
    Node(int val)
    {
        data = val;
        link = NULL;
    }
};
void Insert(Node *&head, int v)
{
    Node *n = new Node(v);
    if (head == NULL)
        head = n;
    else
    {
        Node *t = head;
        while (t->link != NULL)
        {
            t = t->link;
        }
        t->link = n;
    }
}
void Display(Node *t)
{
    if (t)
    {
        cout << t->data << " ";
        Display(t->link);
    }
}
int main()
{
    Node *head = NULL;
    Insert(head, 1);
    Insert(head, 2);
    Insert(head, 3);
    Insert(head, 4);
    Display(head);
    return 0;
}