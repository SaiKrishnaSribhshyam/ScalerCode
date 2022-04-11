/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A==null)
            return B;
        if(B==null)
            return A;
        ListNode head;
        ListNode temp;
        if(A.val<B.val){
            temp=A;
            A=A.next;
        }
        else{
            temp=B;
            B=B.next;
        }
        head=temp;
        while(A!=null && B!=null){
            if(A.val<B.val){
                temp.next=A;
                A=A.next;
            }
            else{
                temp.next=B;
                B=B.next;
            }
            temp=temp.next;
        }

        if(A!=null)
            temp.next=A;
        else if(B!=null)
            temp.next=B;
        
        return head;
    }
}
