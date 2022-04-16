/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return head;
        RandomListNode A=head;
        HashMap<RandomListNode,RandomListNode> mapOriginaltoCopy=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode prev=new RandomListNode(head.label);
        RandomListNode newHead=prev;
        mapOriginaltoCopy.put(A,prev);
        while(A!=null){
            A=A.next;
            if(A==null){
                prev.next=null;
                break;
            }
            RandomListNode currNode=new RandomListNode(A.label);
            mapOriginaltoCopy.put(A,currNode);
            prev.next=currNode;
            prev=currNode;
        }
        A=head;
        RandomListNode temp=newHead;
        while(A!=null){
            if(A.random!=null){
                temp.random=mapOriginaltoCopy.get(A.random);
            }
            A=A.next;
            temp=temp.next;
        }
        return newHead;
    }
}
