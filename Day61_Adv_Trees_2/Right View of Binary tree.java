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
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> levelTraversal=new ArrayList();
        Queue<TreeInfo> q=new LinkedList();
        TreeInfo root=new TreeInfo(A,0);
        TreeInfo temp;
        q.add(root);
        ArrayList<Integer> thislevel;
        while(q.size()>0){
            temp=q.remove();
            if(temp.level<=levelTraversal.size()-1){
                thislevel=levelTraversal.get(temp.level);
                thislevel.add(temp.node.val);
            }
            else{
                thislevel=new ArrayList<Integer>();
                thislevel.add(temp.node.val);
                levelTraversal.add(thislevel);
            }
            if(temp.node.left!=null)
                q.add(new TreeInfo(temp.node.left,temp.level+1));
            if(temp.node.right!=null)
                q.add(new TreeInfo(temp.node.right,temp.level+1));
        }
        ArrayList<Integer> leftview=new ArrayList();
        for(ArrayList<Integer> list:levelTraversal)
            leftview.add(list.get(list.size()-1));
        
        return leftview;
    }
}
