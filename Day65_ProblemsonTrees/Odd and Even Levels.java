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
    public int solve(TreeNode A) {
        if(A==null)
            return 0;
        Queue<TreeNode> q=new LinkedList();
        q.offer(A);
        long oddSum=0,evenSum=0;
        int level=1;
        while(q.size()>0){
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode temp=q.poll();
                if(level%2==0)
                    evenSum+=temp.val;
                else
                    oddSum+=temp.val;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            level++;
        }
        return (int)(oddSum-evenSum);
    }
}
