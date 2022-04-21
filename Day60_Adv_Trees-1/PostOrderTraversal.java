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
    public void deepPush(TreeNode A,Stack<TreeNode> visitedNodes,ArrayList<Integer> nodeVals){
        if(A==null)
            return;
        TreeNode temp=A;
        nodeVals.add(temp.val);
        visitedNodes.push(temp);
        while(temp.right!=null){
            temp=temp.right;
            nodeVals.add(temp.val);
            visitedNodes.push(temp);
        }

    }
    public int[] postorderTraversal(TreeNode A) {
        Stack<TreeNode> visitedNodes=new Stack();
        ArrayList<Integer> nodeVals=new ArrayList();
        deepPush(A,visitedNodes,nodeVals);
        TreeNode temp;
        while(visitedNodes.size()>0){
            temp=visitedNodes.pop();
            deepPush(temp.left,visitedNodes,nodeVals);
        }
        int[] postOrder=new int[nodeVals.size()];
        int j=0;
        for(int i=nodeVals.size()-1;i>=0;i--){
            postOrder[j]=nodeVals.get(i);
            j++;
        }
        return postOrder;
    }
}
