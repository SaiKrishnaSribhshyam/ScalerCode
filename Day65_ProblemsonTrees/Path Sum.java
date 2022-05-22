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
    public int checkSum(TreeNode A,int parentSum,int sum){
        if(A==null)
            return 0;
        
        int currSum=parentSum+A.val;
        if(A.left==null && A.right==null && currSum==sum)
            return 1;
        int left=checkSum(A.left,currSum,sum);
        int right=checkSum(A.right,currSum,sum);
        if(left==1 || right==1)
            return 1;
        
        return 0;
    }
    public int hasPathSum(TreeNode A, int B) {
        return checkSum(A,0,B);
    }
}
