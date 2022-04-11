/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        if(A==null || A.next==null || B==1)
            return A;
        
        ListNode h2=null;
        ListNode temp,linkToNewhead=A;
        int k=B;

        while(k>0 && A!=null ){
            temp=A;
            A=A.next;
            temp.next=h2;
            h2=temp;
            k--;
        }

        linkToNewhead.next=reverseList(A,B);
        return h2;

    }
}
