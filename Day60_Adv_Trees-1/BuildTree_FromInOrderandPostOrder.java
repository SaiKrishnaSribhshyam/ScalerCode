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
    public TreeNode getRoot(int[] A,int[] B,int sIn,int eIn,int sPost,int ePost){
        if(sIn>eIn)
            return null;
        TreeNode root=new TreeNode(B[ePost]);
        int rootIndex=inOrder.get(B[ePost]);
        int leftNodes=rootIndex-sIn;
        root.left=getRoot(A,B,sIn,rootIndex-1,sPost,sPost+leftNodes-1);
        root.right=getRoot(A,B,rootIndex+1,eIn,sPost+leftNodes,ePost-1);
        return root;
    }
    public TreeNode buildTree(int[] A, int[] B) {
        for(int i=0;i<A.length;i++)
            inOrder.put(A[i],i);
        
        return getRoot(A,B,0,A.length-1,0,B.length-1);
    }
}
