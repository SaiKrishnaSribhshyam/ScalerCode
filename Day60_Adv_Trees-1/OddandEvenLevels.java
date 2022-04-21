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
    public int evenSum=0;
    public int oddSum=0;
    public void updateSum(TreeNode A,int prevLevel){
        if(A==null)
            return;
        
        int thisLevel=prevLevel+1;
        if(thisLevel%2==0)
            evenSum+=A.val;
        else
            oddSum+=A.val;
        
        updateSum(A.left,thisLevel);
        updateSum(A.right,thisLevel);
    }
    public int solve(TreeNode A) {
        updateSum(A,0);
        return oddSum-evenSum;

    }
}
