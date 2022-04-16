/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapFirstTwoNodes(ListNode A){
        if(A==null || A.next==null)
            return A;
        
        ListNode head=A;
        ListNode h2=null;

        ListNode temp=A;
        A=A.next;
        temp.next=h2;
        h2=temp;
        temp=A;
        A=A.next;
        temp.next=h2;
        h2=temp;
        head.next=A;
        return h2;
    }
    public ListNode swapPairs(ListNode A) {
        if(A==null || A.next==null)
            return A;
        
        ListNode fast=A;
        fast=fast.next.next;
        ListNode newHead=swapFirstTwoNodes(A);
        //ListNode temp=fast;
        while(fast!=null && fast.next!=null){
            //temp=fast;
            A.next=swapFirstTwoNodes(fast);
            A=fast;
            fast=fast.next;
        }
        return newHead;
    }
}
