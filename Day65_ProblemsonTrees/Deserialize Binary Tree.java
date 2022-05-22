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
    public TreeNode solve(ArrayList<Integer> A) {
        if(A.size()==0)
            return null;
        TreeNode root=new TreeNode(A.get(0));
        Queue<TreeNode> q=new LinkedList();
        q.offer(root);
        int index=1;
        while(q.size()>0){
            int length=q.size();
            for(int i=0;i<length;i++){
                int leftVal=A.get(index++);
                int rightVal=A.get(index++);
                TreeNode left=null,right=null;
                if(leftVal!=-1)
                    left=new TreeNode(leftVal);
                if(rightVal!=-1)
                    right=new TreeNode(rightVal);
                
                TreeNode parent=q.poll();
                parent.left=left;
                parent.right=right;
                if(left!=null)
                    q.offer(left);
                if(right!=null)
                    q.offer(right);
            }
        }
        return root;
    }
}
