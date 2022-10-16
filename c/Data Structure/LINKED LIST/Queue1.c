#include <stdio.h>
#include <stdlib.h>
struct Queue
{
 int size;
 int front;
 int rear;
 int *Q;
};
void create(struct Queue *q,int size)
{
 q->size=size;
 q->front=q->rear=-1;
 q->Q=(int *)malloc(q->size*sizeof(int));
}
void enqueue(struct Queue *q,int x)
{
 if(q->rear==q->size-1)
 printf("Queue is Full");
 else
 {
 q->rear++;
 q->
 Q[q->rear]=x;
 }
}
int dequeue(struct Queue *q)
{
 int x=-1;

 if(q->front==q->rear)
 printf("Queue is Empty\n");


 else
 {
 
 q->front++;
 x=q->Q[q->front];
    if((q->front==q->rear))
        {q->front=-1;
        q->rear=-1;}
    return x;
 }

}
void Display(struct Queue q)
{
 int i;

 for(i=q.front+1;i<=q.rear;i++)
 printf("%d ",q.Q[i]);
 printf("\n");
}
int main()
{
 struct Queue q;
 create(&q,5);

 enqueue(&q,10);
 enqueue(&q,900);
 enqueue(&q,40);
 enqueue(&q,70);
enqueue(&q,80);


 Display(q);

printf("%d \n ",dequeue(&q));
printf("%d \n",dequeue(&q));
printf("%d \n",dequeue(&q));
printf("%d \n",dequeue(&q));
printf("%d \n",dequeue(&q));

Display(q);
enqueue(&q,70);

enqueue(&q,70);
enqueue(&q,77);
Display(q);



 return 0;
}