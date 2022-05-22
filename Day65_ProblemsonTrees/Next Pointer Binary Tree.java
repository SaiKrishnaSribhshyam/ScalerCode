/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
public TreeLinkNode getNextRight(TreeLinkNode start){
    TreeLinkNode temp=start.next;
    while(temp!=null){
        if(temp.left!=null)
            return temp.left;
        else if(temp.right!=null)
            return temp.right;
        temp=temp.next;
    }
    return null;
}
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        TreeLinkNode start=root;
        start.next=null;
        while(start!=null){
            TreeLinkNode temp=start;
            while(temp!=null){
                if(temp.left!=null && temp.right!=null){
                    temp.left.next=temp.right;
                    temp.right.next=getNextRight(temp);
                }
                else if(temp.left!=null)
                    temp.left.next=getNextRight(temp);
                else if(temp.right!=null)
                    temp.right.next=getNextRight(temp);
                
                temp=temp.next;
            }
            if(start.left!=null)
                start=start.left;
            else if(start.right!=null)
                start=start.right;
            else
                start=getNextRight(start);
        }
    }
}
