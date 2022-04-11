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
    public int solve(ListNode A) {
        if(A==null || A.next==null)
            return A.val;
        ListNode head=A;
        int length=getLength(A);
        int mid=(length/2)+1;
        //System.out.println("Length,mid"+length+","+mid);
        A=head;
        while(mid>1){
            A=A.next;
            mid--;
        }
        return A.val;
        
    }
}
