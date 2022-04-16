/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode merge(ListNode A,ListNode B){
        if(A==null)
            return B;
        else if(B==null)
            return A;
        
        ListNode head,temp;
        if(A.val>B.val){
            head=B;
            B=B.next;
        }
        else{
            head=A;
            A=A.next;
        }
        temp=head;
        while(A!=null && B!=null){
            if(A.val>B.val){
                temp.next=B;
                B=B.next;
            } else {
                temp.next=A;
                A=A.next;
            }
            temp=temp.next;
        }
        if(A!=null)
            temp.next=A;
        else if(B!=null)
            temp.next=B;
        return head;
    }

    public ListNode mergeSort(ArrayList<ListNode> A,int start,int end){
        if(start==end)
            return A.get(start);
        
        int mid=(start+end)/2;
        ListNode firstPart=mergeSort(A,start,mid);
        ListNode secondPart=mergeSort(A,mid+1,end);
        ListNode head=merge(firstPart,secondPart);
        return head;
    }

	public ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a.size()==1)
            return a.get(0);
        
        return mergeSort(a,0,a.size()-1);

	}
}
