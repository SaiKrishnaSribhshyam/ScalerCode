/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        if(A==null || A.next==null)
            return A;
        
        //ListNode head=A;
        ListNode slow=A;
        ListNode fast=A;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                break;
        }
        slow=A;
        ListNode temp=fast;
        while(fast!=slow){
            temp=fast;
            fast=fast.next;
            slow=slow.next;
        }
        temp.next=null;
        return A;
    }
}
