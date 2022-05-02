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
    public TreeNode makeBBST(List<Integer> A,int start,int end){
        if(start>end)
            return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(A.get(mid));
        root.left=makeBBST(A,start,mid-1);
        root.right=makeBBST(A,mid+1,end);
        return root;
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return makeBBST(A,0,A.size()-1);
    }
}
