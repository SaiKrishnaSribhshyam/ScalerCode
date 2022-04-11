/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode breakAtMid(ListNode A){

        ListNode slow=A;
        ListNode fast=A;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow;
        slow=slow.next;
        temp.next=null;
        return slow;
    }
    public ListNode sortList(ListNode A) {
        if(A==null || A.next==null)
            return A;
        
        ListNode head=A;
        ListNode h2=breakAtMid(A);
        //System.out.print(A.val +" " +h2.val);
        ListNode h1=sortList(A);
        h2=sortList(h2);
        ListNode temp;
        if(h1.val<h2.val){
            temp=h1;
            h1=h1.next;
        }
        else{
            temp=h2;
            h2=h2.next;
        }
        head=temp;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                temp.next=h1;
                h1=h1.next;
            }
            else {
                temp.next=h2;
                h2=h2.next;
            }
            temp=temp.next;
        }

        if(h1!=null)
            temp.next=h1;
        else if(h2!=null)
            temp.next=h2;
        
        return head;
    }
}
