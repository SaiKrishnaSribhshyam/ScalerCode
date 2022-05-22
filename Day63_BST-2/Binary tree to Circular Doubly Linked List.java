/*
class TreeNode {
    int val;
    TreeNode left, right;
    ListNode(int x) {
        val = x;
        left = right = null;
    }
}
*/
public class TreeInfo{
    TreeNode first;
    TreeNode last;
    public TreeInfo(TreeNode first,TreeNode last){
        this.first=first;
        this.last=last;
    }
}
public TreeInfo getLinkedList(TreeNode A,TreeInfo T){
    if(A==null)
        return null;
    TreeInfo leftInfo=getLinkedList(A.left,new TreeInfo(T.first,A));
    TreeInfo rootInfo=new TreeInfo(null,null);
    if(leftInfo==null)
        rootInfo.first=A;
    else{
        A.left=leftInfo.last;
        rootInfo.first=leftInfo.first;
    }
    TreeInfo rightInfo=getLinkedList(A.right,new TreeInfo(A,T.last));
    if(rightInfo==null)
        rootInfo.last=A;
    else{
        A.right=rightInfo.first;
        rootInfo.last=rightInfo.last;
    }
    rootInfo.first.left=T.first;
    rootInfo.last.right=T.last;
    return rootInfo;
}
TreeNode solve (TreeNode root) {
    if(root==null)   
        return null;
    
    TreeInfo linkedList=getLinkedList(root,new TreeInfo(null,null));
    linkedList.first.left=linkedList.last;
    linkedList.last.right=linkedList.first;
    return linkedList.first;
}