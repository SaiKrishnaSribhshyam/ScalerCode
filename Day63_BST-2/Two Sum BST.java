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
    public void deepLeftPush(TreeNode A,Stack<TreeNode> leftStack){
        if(A==null)
            return;
        //TreeNode temp=A;
        while(A!=null){
            leftStack.push(A);
            A=A.left;
        }
    }
    public void deepRightPush(TreeNode A,Stack<TreeNode> rightStack){
        if(A==null)
            return;
        while(A!=null){
            rightStack.push(A);
            A=A.right;
        }
    }
    public int t2Sum(TreeNode A, int B) {
        Stack<TreeNode> leftStack=new Stack();
        Stack<TreeNode> rightStack=new Stack();
        if(A==null)
            return 0;
        deepLeftPush(A,leftStack);
        deepRightPush(A,rightStack);
        while(leftStack.size()>0 && rightStack.size()>0){
            if(leftStack.peek()==rightStack.peek())
                break;
            int left=leftStack.peek().val;
            int right=rightStack.peek().val;
            //System.out.println(left+"-"+right);
            if(left+right<B){
                TreeNode temp=leftStack.pop();
                if(temp.right!=null)
                    deepLeftPush(temp.right,leftStack);
            }
            else if(left+right>B){
                TreeNode temp=rightStack.pop();
                if(temp.left!=null)
                    deepRightPush(temp.left,rightStack);
            }
            else
                return 1;
        }

        return 0;
    }
}
