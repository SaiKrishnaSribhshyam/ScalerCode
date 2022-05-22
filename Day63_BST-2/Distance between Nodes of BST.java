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
    public TreeNode getLCA(TreeNode A,int B,int C){
        if(A==null)
            return null;
        if(A.val==B||A.val==C)
            return A;
        TreeNode left=getLCA(A.left,B,C);
        TreeNode right=getLCA(A.right,B,C);
        if(left!=null && right!=null)
            return A;
        if(left!=null)
            return left;
        return right;

    }
    public int findDistance(TreeNode A,int B){
        if(A==null)
            return -1;
        if(A.val==B)
            return 0;
        int left=findDistance(A.left,B);
        int right=findDistance(A.right,B);
        int result=Math.max(left,right);
        if(result!=-1)
            return result+1;
        return -1;
    }
    public int solve(TreeNode A, int B, int C) {
        TreeNode commonAncestor=getLCA(A,B,C);
        int lcatoB=findDistance(commonAncestor,B);
        int lcatoC=findDistance(commonAncestor,C);
        //System.out.print(lcatoB+"-"+lcatoC);
        return lcatoB+lcatoC;
    }
}
