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
    public int getMax(TreeNode A){
        if(A==null)
            return Integer.MAX_VALUE;
        
        int max=getMax(A.right);
        if(max==Integer.MAX_VALUE)
            return A.val;
        return max;
    }
    public int getMin(TreeNode A){
        if(A==null)
            return -1;
        int min=getMin(A.left);
        if(min==-1)
            return A.val;
        return min;
    }
    public int isValidBST(TreeNode A) {
        if(A==null)
            return 1;
        
        if(isValidBST(A.left)==1 && isValidBST(A.right)==1){
            int leftVal=-1;
            long rightVal=A.val+1L;
            if(A.left!=null)
                leftVal=getMax(A.left);
            if(A.right!=null)
                rightVal=getMin(A.right);

            if(A.val>leftVal && A.val<rightVal)
                return 1;
        }
        return 0;
    }
}
