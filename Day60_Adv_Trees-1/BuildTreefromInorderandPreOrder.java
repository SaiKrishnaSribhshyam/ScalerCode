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
    HashMap<Integer,Integer> inOrder=new HashMap();
    public TreeNode getTreeNode(int[] A,int[] B,int sPre,int ePre,int sIn,int eIn){
        if(sPre>ePre)
            return null;
        TreeNode root=new TreeNode(A[sPre]);
        int rootIndex=inOrder.get(A[sPre]);
        int leftNodesCount=rootIndex-sIn;
        root.left=getTreeNode(A,B,sPre+1,sPre+rootIndex-sIn,sIn,rootIndex-1);
        root.right=getTreeNode(A,B,sPre+rootIndex-sIn+1,ePre,rootIndex+1,eIn);
        return root;
    }
    public TreeNode buildTree(int[] A, int[] B) {
        for(int i=0;i<B.length;i++)
            inOrder.put(B[i],i);
        return getTreeNode(A,B,0,A.length-1,0,B.length-1);
    }
}
