public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
    // Write your code here
    
    if(llist == null){
        return llist;
    }
    
    SinglyLinkedListNode new_head = llist;
    
    while(llist.next != null){
        
        if(llist.data == llist.next.data){
            
         llist.next = llist.next.next;
        }
        
        else{
            llist = llist.next;
        }
    }
    
    return new_head;

    }
