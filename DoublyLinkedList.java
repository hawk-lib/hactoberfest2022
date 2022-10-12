package com.tutorialspoint.list;

public class DoublyLinkedListDemo {
    public static void main(String args[]){
        DoublyLinkedList list = new DoublyLinkedList();
        
        list.insertFirst(1, 10);
        list.insertFirst(2, 20);
        list.insertFirst(3, 30);
        
        list.insertLast(4, 1);
        list.insertLast(5, 40);
        list.insertLast(6, 56);
       
        System.out.print("\nList (First to Last): ");  
        list.displayForward();
        System.out.println("");
        System.out.print("\nList (Last to first): "); 
        list.displayBackward();
        
        System.out.print("\nList , after deleting first record: ");
        list.deleteFirst();        
        list.displayForward();
        
        System.out.print("\nList , after deleting last record: ");  
        list.deleteLast();
        list.displayForward();
        
        System.out.print("\nList , insert after key(4) : ");  
        list.insertAfter(4,7, 13);
        list.displayForward();
        
        System.out.print("\nList  , after delete key(4) : ");  
        list.delete(4);
        list.displayForward();
        
    }
}
