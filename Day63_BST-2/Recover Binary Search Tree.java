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
    TreeNode n1;
    TreeNode n2;
    TreeNode prev;
    public TreeNode getMisplacedNodes(TreeNode A){
        if(A==null)
            return null;
        getMisplacedNodes(A.left);
        if(prev!=null && A.val<prev.val){
            if(n1==null && n2==null){
                n1=prev;
                n2=A;
            }
            else{
                n2=A;
                return A;
            }
        }
        prev=A;
        return getMisplacedNodes(A.right);
    }
    public int[] recoverTree(TreeNode A) {
        getMisplacedNodes(A);
        int[] result=new int[2];
        result[0]=n2.val;
        result[1]=n1.val;
        return result;
    }
}
