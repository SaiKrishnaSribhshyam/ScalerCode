/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {

        if(A==null || A.next==null)
            return A;
        
        ListNode h2=null;
        ListNode temp;
        while(A.next!=null){
            temp=A;
            A=A.next;
            temp.next=h2;
            h2=temp;
        }
        A.next=h2;
        return A;
    }
}
