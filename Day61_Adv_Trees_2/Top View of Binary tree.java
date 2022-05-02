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
        private TreeNode node;
        private int distance;
        public TreeInfo(TreeNode node,int distance){
            this.node=node;
            this.distance=distance;
        }
        public TreeNode getNode(){
            return this.node;
        }
        public int getDistance(){
            return this.distance;
        }
    }
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeInfo> q=new LinkedList();
        HashMap<Integer,Integer> distanceMap=new HashMap();
        ArrayList<Integer> topview=new ArrayList();
        if(A==null)
            return topview;
        
        q.offer(new TreeInfo(A,0));
        while(q.size()>0){
            TreeInfo temp=q.poll();
            if(!distanceMap.containsKey(temp.getDistance())){
                distanceMap.put(temp.getDistance(),temp.getNode().val);
            }
            if(temp.getNode().left!=null)
                q.offer(new TreeInfo(temp.getNode().left,temp.getDistance()-1));
            if(temp.getNode().right!=null)
                q.offer(new TreeInfo(temp.getNode().right,temp.getDistance()+1));
        }
        for(Map.Entry<Integer,Integer> E:distanceMap.entrySet()){
            topview.add(E.getValue());
        }
        return topview;
    }
}
