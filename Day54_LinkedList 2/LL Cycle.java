/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode A) {
        if(A==null || A.next==null)
            return A;
        
        ListNode head=A;

        ListNode slow=A;
        ListNode fast=A;
        int k=0;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                break;
            k++;
        }

        if(fast==null || fast.next==null)
            return null;
        
        slow=A;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
	}

}
