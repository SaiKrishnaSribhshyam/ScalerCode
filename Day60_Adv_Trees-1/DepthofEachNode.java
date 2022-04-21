    /*
    Definition for TreeNode.
    static public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; this.depth = -1;}
    }
    */
    public static void setDepth(TreeNode A,int parentDepth){
        if(A==null)
            return;
        
        A.depth=parentDepth+1;
        setDepth(A.left,A.depth);
        setDepth(A.right,A.depth);
    }

    static void solve(TreeNode A){
    
        setDepth(A,0);
    
    }

        