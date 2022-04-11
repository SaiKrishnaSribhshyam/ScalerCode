/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class Solution {
    public ListNode reverseFromHead(ListNode A,int C){
    ListNode start=A;
    ListNode temp;
    ListNode h2=null;
    int count=0;
    while(count<C-1 && A.next!=null){
        temp=A;
        A=A.next;
        temp.next=h2;
        h2=temp;
        count++;
    }

    
    if(A.next==null){
        A.next=h2;
        return A;
    }

    start.next=A.next;
    A.next=h2;

    return A;

}
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if(A==null || A.next==null || B==C)
            return A;
        
        if(B==1)
            return reverseFromHead(A,C);

        ListNode head=A;
        ListNode temp=A;
        int position=0;

        while(position<B-1 && head.next!=null){
            temp=A;
            A=A.next;
            position++;
        }


        ListNode newHead=reverseFromHead(A,(C-B+1));
        temp.next=newHead;
        return head;
    }
}
