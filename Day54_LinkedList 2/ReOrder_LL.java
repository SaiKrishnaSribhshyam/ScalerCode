/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode breakListatMid(ListNode A){
        ListNode slow=A;
        ListNode fast=A;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        A=slow;
        slow=slow.next;
        A.next=null;
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
    public ListNode reorderList(ListNode A) {
        if(A==null || A.next==null)
            return A;
        
        ListNode head=A;
        ListNode midListHead=breakListatMid(A);
        midListHead=reverse(midListHead);
        int count=0;
        ListNode temp=A;
        while(A!=null && midListHead!=null){
            if(count%2==0){
                temp=A;
                A=A.next;
                temp.next=midListHead;
            }
            else{
                temp=midListHead;
                midListHead=midListHead.next;
                temp.next=A;
            }
            count++;
        }
        return head;

    }
}
