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
    public int getCeiling(TreeNode A,int key){
        if(A==null)
            return -1;
        
        int ceiling=-1;
        if(A.val==key)
            return A.val;
        else if(A.val>key){
            ceiling=getCeiling(A.left,key);
        }
        else
            ceiling=getCeiling(A.right,key);

        if(ceiling==-1 && A.val>key)
            ceiling=A.val;
        
        return ceiling;

    }

    public int getFloor(TreeNode A,int key){
        if(A==null)
            return -1;
        
        int floor=-1;
        if(A.val==key)
            return A.val;
        else if(A.val>key)
            floor=getFloor(A.left,key);
        else if(A.val<key)
            floor=getFloor(A.right,key);

        if(floor==-1 && A.val<key)
            floor=A.val;
        
        return floor;
    }
    public ArrayList<ArrayList<Integer>> solve(TreeNode A, ArrayList<Integer> B) {
        int queries=B.size();
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        for(int i=0;i<queries;i++){
            ArrayList<Integer> floorCeil=new ArrayList();
            floorCeil.add(getFloor(A,B.get(i)));
            floorCeil.add(getCeiling(A,B.get(i)));
            result.add(floorCeil);
        }
        return result;
    }
}
