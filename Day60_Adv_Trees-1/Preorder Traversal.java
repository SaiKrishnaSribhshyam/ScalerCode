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
    public int[] preorderTraversal(TreeNode A) {
        Stack<TreeNode> preOrder=new Stack();
        ArrayList<Integer> resultList=new ArrayList();
        int[] result;
        if(A==null){
            result=new int[0];
            return result;
        }
        TreeNode temp;
        preOrder.push(A);
        while(preOrder.size()>0){
            temp=preOrder.pop();
            resultList.add(temp.val);
            if(temp.right!=null)
                preOrder.push(temp.right);
            if(temp.left!=null)
                preOrder.push(temp.left);
        }
        result=new int[resultList.size()];
        for(int i=0;i<resultList.size();i++)
            result[i]=resultList.get(i);
        return result;
    }
}
