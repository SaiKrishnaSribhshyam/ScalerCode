/*
class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
*/
public ListNode getMid(ListNode A){
    if(A==null || A.right==null)
        return A;

    ListNode slow=A;
    ListNode fast=A;
    while(fast.right!=null && fast.right.right!=null){
        slow=slow.right;
        fast=fast.right.right;
    }
    return slow;
}
public ListNode merge(ListNode A,ListNode B){
    if(A==null)
        return B;
    if(B==null)
        return A;
    
    ListNode head;

    if(A.val>B.val){
        head=B;
        B=B.down;
        //A.right=A.down;
        //A.down-null;
    }
    else {
        head=A;
        A=A.down;
        //B.right=B.down;
        //B.down=null;
    }
    ListNode temp=head;
    while(A!=null && B!=null){
        if(A.val>B.val){
            temp.down=B;
            B=B.down;
        }
        else{
            temp.down=A;
            A=A.down;
        }
        temp=temp.down;
    }
    if(A!=null)
        temp.down=A;
    else
        temp.down=B;

    return head;
}
ListNode flatten(ListNode root) {
    if(root==null || root.right==null)
        return root;
    
    ListNode mid=getMid(root);
    ListNode A=mid;
    mid=mid.right;
    A.right=null;
    root=flatten(root);
    mid=flatten(mid);
    root=merge(root,mid);
    return root;
}