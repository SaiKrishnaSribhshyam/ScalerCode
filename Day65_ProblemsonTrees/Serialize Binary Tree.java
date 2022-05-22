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
    public ArrayList<Integer> solve(TreeNode A) {
        if(A==null)
            return null;
        Queue<TreeNode> q=new LinkedList();
        ArrayList<Integer> serialTree=new ArrayList();
        q.offer(A);
        while(q.size()>0){
            TreeNode temp=q.poll();
            if(temp==null)
                serialTree.add(-1);
            else{
                serialTree.add(temp.val);
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
        return serialTree;
    }
}
