public class customStack
{
    private int arr[];
    private int top;
    private int capacity;

    customStack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop()
    {
        // check for stack underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        System.out.println("Removing " + peek());

        return arr[top--];
    }

    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }

        return -1;
    }


    public int size() {
        return top + 1;
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public boolean isFull() {
        return top == capacity - 1;
    }

    public void display(){
        for(int i=0; i<=top; i++){
            System.out.print(arr[i] + "->");
        }
        System.out.println("END");
    }
}
