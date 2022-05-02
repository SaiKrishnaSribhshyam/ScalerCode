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
    public class TreeInfo{
        TreeNode node;
        int level;
        public TreeInfo(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public int[] solve(TreeNode A) {
        Queue<TreeInfo> q=new LinkedList();
        ArrayList<ArrayList<Integer>> levelOrder=new ArrayList();
        int[] leftview;
        if(A==null) {
            leftview=new int[0];
            return leftview;
        }
        q.offer(new TreeInfo(A,0));
        while(q.size()>0){
            TreeInfo temp=q.poll();
            if((levelOrder.size()-1)<temp.level){
                ArrayList<Integer> thislevel=new ArrayList();
                thislevel.add(temp.node.val);
                levelOrder.add(thislevel);
            }
            else {
                ArrayList<Integer> thislevel=levelOrder.get(temp.level);
                thislevel.add(temp.node.val);
            }
            if(temp.node.left!=null)
                q.add(new TreeInfo(temp.node.left,temp.level+1));
            
            if(temp.node.right!=null)
                q.add(new TreeInfo(temp.node.right,temp.level+1));
        }

        leftview=new int[levelOrder.size()];
        int i=0;
        for(ArrayList<Integer> thislevel:levelOrder){
            leftview[i]=thislevel.get(0);
            i++;
        }

        return leftview;
    }
}
