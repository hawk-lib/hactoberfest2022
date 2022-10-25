

import java.util.*;

public class All_Collections {
  private static void stackOperatins(){
    Stack<Integer> stack=new Stack<>();
    stack.push(20);
    stack.push(509);
    stack.push(786);
    stack.push(43);
//    System.out.println(stack);[20, 509, 786, 43]
//    System.out.println(stack.peek()); 43
//    System.out.println(stack.pop()); //43 and remove top element
  }
  private static void queueOperations(){
    Queue<Integer> queue=new LinkedList<>();
    queue.add(30);
    queue.add(46);
    queue.add(89);
    queue.add(60);
    System.out.println(queue);
    System.out.println(queue.peek());
    System.out.println(queue.poll()); //it removed head of the queue
    System.out.println(queue);
  }
  private static void listOperations(){
    List<Integer> list=new ArrayList<>();
    list.add(30);
    list.add(647);
    list.add(53);
    list.add(460);
    list.add(8967);
    System.out.println(list);
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list); //print reverse of sorted
  }
  private static void arrayOperations(){
    int arr[]={10,14,56,3,89,11,45,23,19,390,50};
//    sort the array using builtin function
//    Arrays.sort(arr);
//    System.out.println(Arrays.toString(arr)); [3, 10, 11, 14, 19, 23, 45, 50, 56, 89, 390]
  }
  public static void main(String[] args) {
//    arrayOperations();
//    stackOperatins();
//    queueOperations();
    listOperations();
  }
}
