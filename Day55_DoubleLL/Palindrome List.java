/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode getMidNode(ListNode A){
        ListNode slow=A;
        ListNode fast=A;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode A){
        if(A==null || A.next==null)
            return A;
        
        ListNode temp=A;
        ListNode h2=null;

        while(A!=null){
            temp=A;
            A=A.next;
            temp.next=h2;
            h2=temp;
        }
        return h2;
    }

    public int lPalin(ListNode A) {
        if(A==null|A.next==null)
            return 1;
        
        ListNode head=A;
        ListNode mid=getMidNode(A);
        A=mid;
        mid=mid.next;
        A.next=null;
        mid=reverse(mid);
        A=head;
        while(A!=null && mid!=null){
            if(A.val!=mid.val)
                return 0;
            A=A.next;
            mid=mid.next;
        }
        return 1;
    }
}
