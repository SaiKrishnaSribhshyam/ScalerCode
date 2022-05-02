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
    public int checkHBBST(TreeNode root){
        if(root==null)
            return 0;
        int left=checkHBBST(root.left);
        int right=checkHBBST(root.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1)
            return -1;
        
        return Math.max(left,right)+1;
    }
    public int isBalanced(TreeNode A) {
        if(A==null)
            return 1;
        int result=checkHBBST(A);
        if(result==-1)
            return 0;
        return 1;
    }
}
