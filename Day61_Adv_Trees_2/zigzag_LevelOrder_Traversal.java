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
    public int[][] zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> zizag=new ArrayList();
        Stack<TreeNode> left=new Stack();
        Stack<TreeNode> right=new Stack();
        if(A==null)
            return zigzag;
        
        right.push(A);
        TreeNode temp;
        while(left.size()>0 || right.size()>0){
            ArrayList<Integer> thisLevel=new ArrayList();
            while(left.size()>0){
                temp=left.pop();
                thisLevel.add(temp.val);
                if(temp.right!=null)
                    right.push(temp.right);
                if(temp.left!=null)
                    right.push(temp.left);
            }
            if(thisLevel.size()>0){
                zizag.add(thisLevel);
                break;
            }
            while(right.size()>0){
                temp=right.pop();
                thislevel.add(temp.val);
                if(temp.left!=null)
                    left.add(temp.left);
                if(temp.right!=null)
                    left.add(temp.right);
            }
            if(thisLevel.size()>0){
                zizag.add(thisLevel);
            }
        }
        return zigzag;
        
    }
}
