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
    public void inOrder(TreeNode A,ArrayList<Integer> list){
        if(A==null)
            return;
        inOrder(A.left,list);
        list.add(A.val);
        inOrder(A.right,list);
    }
    public int solve(TreeNode A, TreeNode B) {
        ArrayList<Integer> inOrderA=new ArrayList();
        ArrayList<Integer> inOrderB=new ArrayList();
        inOrder(A,inOrderA);
        inOrder(B,inOrderB);
        int i=0,j=0;
        long result=0;
        long mod=(long)Math.pow(10,9)+7;
        while(i<inOrderA.size() && j<inOrderB.size()){
            if(inOrderA.get(i).intValue()==inOrderB.get(j).intValue()){
                result=(result+0l+inOrderA.get(i).intValue())%mod;
                i++;
                j++;
            }
            else if(inOrderA.get(i)<inOrderB.get(j))
                i++;
            else
                j++;

            //System.out.print(result+" ");
        }
        //result=result%mod;
        if(result<0)
            result=result+mod;
        return (int)(result);
    }
}
