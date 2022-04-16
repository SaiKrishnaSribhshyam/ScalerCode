/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(A==null)
            return B;
        if(B==null)
            return A;
        
        int carry=0;
        ListNode sum=new ListNode(0);
        sum.val=A.val+B.val;
        carry=sum.val/10;
        sum.val=sum.val%10;
        ListNode result=sum;
        while(A.next!=null && B.next!=null){
            A=A.next;
            B=B.next;
            ListNode currsum=new ListNode(0);
            sum.next=currsum;
            currsum.val=A.val+B.val+carry;
            carry=currsum.val/10;
            currsum.val=currsum.val%10;
            sum=currsum;          
        }
        if(B.next!=null)
            A=B;
        while(A.next!=null){
            A=A.next;
            ListNode currsum=new ListNode(0);
            sum.next=currsum;
            currsum.val=A.val+carry;
            carry=currsum.val/10;
            currsum.val=currsum.val%10;
            sum=currsum;    
        }
        if(carry!=0){
            ListNode currsum=new ListNode(carry);
            sum.next=currsum;
        }   


        return result;
    }
}
