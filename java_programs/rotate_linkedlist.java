/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<1 || head.next==null) return head;
        
       ListNode last = head;
        int len =1;
        while(last.next!=null){
            last=last.next;
            len++;
        }
        last.next=head;
        
        int rotate =k%len; 
        ListNode newlast = head;
        for(int i =0; i<len-rotate-1;i++){
            newlast = newlast.next;
        }
        head= newlast.next;
        newlast.next=null;
        return head;
    }
}