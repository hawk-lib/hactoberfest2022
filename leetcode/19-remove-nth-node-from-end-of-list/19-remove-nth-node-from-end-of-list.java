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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        int i=0;
        ListNode curr=head;
        while(curr!=null){
            i++;
            curr=curr.next;
        }
        i=i-n;
        if(i==0){
            return head.next;
        }
        curr=head;
        while(i>1){
            curr=curr.next;
            i--;
        }
        curr.next=curr.next.next;
        return head;
    }
}