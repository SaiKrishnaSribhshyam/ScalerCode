/*
class ListNode {
    int val;
    ListNode next, random;
    ListNode(int x) {
        val = x;
        next = random = null;
    }
} 
*/
ListNode cloneList(ListNode A) {
    if(A==null)
        return A;
    
    ListNode head=A;
    ListNode temp;

    while(A!=null){
        temp=A.next;
        ListNode copy=new ListNode(A.val);
        A.next=copy;
        copy.next=temp;
        A=temp;
    }
    A=head;
    temp=head.next;
    ListNode newHead=temp;
    while(temp.next!=null){
        if(A.random!=null)
            temp.random=A.random.next;
        else
            temp.random=null;
        A=temp.next;
        temp=A.next;
    }
    temp.random=A.random!=null?A.random.next:null;
    A=head;
    temp=newHead;
    while(temp.next!=null){
        A.next=temp.next;
        temp.next=temp.next.next;
        A=A.next;
        temp=temp.next;
    }
    A.next=null;
    return newHead;
}