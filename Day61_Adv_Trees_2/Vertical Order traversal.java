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
        int distance;
        public TreeInfo(TreeNode node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Queue<TreeInfo> q=new LinkedList();
        ArrayList<ArrayList<Integer>> verticalTraversal=new ArrayList();
        TreeInfo root=new TreeInfo(A,0);
        int rootIndex=-1;
        q.add(root);
        TreeInfo temp;
        while(q.size()>0){
            temp=q.remove();
            int index=temp.distance+rootIndex;
            if(index>=0 && index<=verticalTraversal.size()-1){
                ArrayList<Integer> column=verticalTraversal.get(index);
                column.add(temp.node.val);
            }
            else{
                ArrayList<Integer> newColumn=new ArrayList();
                newColumn.add(temp.node.val);
                if(verticalTraversal.size()>0 && index<0){
                    verticalTraversal.add(0,newColumn);
                    rootIndex++;
                    //System.out.print(rootIndex);
                }
                else{
                    verticalTraversal.add(newColumn);
                    if(rootIndex==-1)
                        rootIndex++;
                }
            }
            if(temp.node.left!=null)
                q.add(new TreeInfo(temp.node.left,temp.distance-1));
            if(temp.node.right!=null)
                q.add(new TreeInfo(temp.node.right,temp.distance+1));
            
            //System.out.println(verticalTraversal);
        }

        return verticalTraversal;
    }
}
