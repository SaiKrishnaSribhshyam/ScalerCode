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
        if(A==null)
            return 0;
        int count=0;
        while(A!=null){
            A=A.next;
            count++;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null||B==0)
            return A;
        int length=getLength(A);
        
        if(B>=length){
            return A.next;
        }
        ListNode head=A;
        int nodeToRemove=length-B+1;
        int count=0;
        ListNode temp=A;
        while(count<nodeToRemove-1 && A!=null){
            temp=A;
            A=A.next;
            count++;
        }

        if(A==null)
            temp.next=null;
        else
            temp.next=A.next;

        return head;

    }
}
