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
    int kthElement=0;
    public int kthsmallest(TreeNode A, int B) {
        if(A==null)
            return -1;
        int left=kthsmallest(A.left,B);
        if(left!=-1)
            return left;
        kthElement++;
        if(kthElement==B)
            return A.val;
        return kthsmallest(A.right,B);

    }
}
