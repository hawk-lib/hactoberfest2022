#include <bits/stdc++.h>
using namespace std;
int* enqueue (int n, int queue[20], int rear, int front, int arr[2])
{
    int val;
    rear = arr[0];
    front = arr[1];
    cout << "Enter the value to be inserted" << endl;
    cin >> val;
    if (rear == n-1)
    {
        cout << "Sorry, Overflow" << endl;
    }
    else if ((front == -1) && (rear == -1))
    {
        rear ++;
        front ++;
        queue[rear] = val;
    }
    else
    {
        rear ++;
        queue[rear] = val;
    }
    arr[0] = rear;
    arr[1] = front;
    return arr;
}
int* dequeue (int n, int queue[20], int rear, int front, int arr[2])
{
    rear = arr[0];
    front = arr[1];
    if (rear == -1 && front == -1)
    {
        cout << "Underflow" << endl;
    }
    else if (rear == front)
    {
        cout << "The element which will be deleted is  " << queue[front] << endl;
        rear = front = -1;
    }
    else
    {
        cout << "The element which will be deleted is  " << queue[front] << endl;
        front ++;
    }
    arr[0] = rear;
    arr[1] = front;
    return arr;
}
int main()
{
    int n;
    int arr[2];
    fill (arr, arr + 2, -1);
    int *p1;
    p1 = arr;
    cout << "Enter the number of elements : " << endl;
    cin >> n;
    int queue[20];
    int rear = -1;
    int front = -1;
    int choice = 1;
    while (choice == 1 || choice == 2)
    {
        cout << "Input 1 for enqueue and 2 for dequeue operation of queue" << endl;
        cin >> choice;
        if (choice == 1)
        {
            p1 = enqueue(n, queue, rear, front, p1);
        }
        else if (choice == 2)
        {
            p1 = dequeue (n, queue, rear, front, p1);
        }
        for (int i = p1[1]; i <= p1[0]; i ++)
        {
            cout <<"\t" << queue[i];
        }
    }
}