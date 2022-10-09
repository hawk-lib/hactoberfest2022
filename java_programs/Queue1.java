package Sample;

public class Queue1 {

    private int size;
    private String[] queArray;
    private int front;
    private int rear;
    private int items;

    public Queue1 (int s){
        size = s;
        queArray = new String[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean isEmpty(){
        return (items == 0);
    }

    public boolean isFull(){
        return (items == size);
    }

    public int size(){
        return items;
    }

    public String peek(){
        return queArray[front];
    }

    public void enqueue(String x){
        if(isFull() == false){
            queArray[++rear] = x;
            items ++;
        }
    }

    public String dequeue(){
        String temp = null;
        if(isEmpty() == false){
            temp = queArray[front++];
            items --;
        }
        return temp;
    }

    public static void main(String[] args) {
        Queue1 myQueue = new Queue1(4);
        myQueue.enqueue("10");
        myQueue.enqueue("20");
        myQueue.enqueue("30");
        myQueue.enqueue("40");

        System.out.println(myQueue.isFull());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isFull());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.peek());
    }

}
