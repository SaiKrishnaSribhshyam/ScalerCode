/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        if(A==null||A.next==null)
            return A;
        
        ListNode head=A;
        ListNode temp=A;
        A=A.next;
        while(A!=null){
            if(A.val==temp.val){
                temp.next=A.next;
                A=A.next;
            }
            else {
                temp=A;
                A=A.next;
            }
        }
        return head;
    }
}
