/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    Stack<TreeNode> inOrderStack=new Stack();
    public void deepPush(TreeNode A){
        if(A==null)
            return;
        
        while(A!=null){
            inOrderStack.push(A);
            A=A.left;
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> inOrder=new ArrayList();
        if(A==null)
            return inOrder;
        
        deepPush(A);
        TreeNode temp;
        while(inOrderStack.size()>0){
            temp=inOrderStack.pop();
            inOrder.add(temp.val);
            deepPush(temp.right);
        }

        return inOrder;
    }
}
