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
    public int getPath(TreeNode A,int B,ArrayList<Integer> path){
        if(A==null)
            return -1;
        //int len=path.size();
        int left=getPath(A.left,B,path);
        int right=getPath(A.right,B,path);
        if(left==1 || right==1 || A.val==B){
            path.add(A.val);
            return 1;
        }
        
        return -1;
    }
    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> pathB=new ArrayList();
        ArrayList<Integer> pathC=new ArrayList();
        getPath(A,B,pathB);
        getPath(A,C,pathC);

        int i=pathB.size()-1,j=pathC.size()-1;
        if(i==-1||j==-1)
            return -1;
        int lowestRoot=pathB.get(i);
        while(i>=0 && j>=0 && pathB.get(i).intValue()==pathC.get(j).intValue()){
            lowestRoot=pathB.get(i).intValue();
            i--;
            j--;
        }
        //System.out.println(pathB);
        //System.out.println(pathC);
        return lowestRoot;
    }
}
