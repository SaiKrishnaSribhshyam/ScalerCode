/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int getLength(ListNode A){
        int count=0;
        while(A.next!=null){
            A=A.next;
            count++;
        }

        return ++count;
    }
    public ListNode solve(ListNode A) {
        if(A==null||A.next==null)
            return null;
        ListNode head=A;
        int length=getLength(A);
        int mid=(length/2)+1;
        A=head;
        ListNode temp=A;
        while(mid>1){
            temp=A;
            A=A.next;
            mid--;
        }

        if(A.next==null)
            temp.next=null;

        temp.next=A.next;

        return head;
    }
}
