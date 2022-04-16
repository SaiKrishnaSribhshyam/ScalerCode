public class Solution {
    private int capacity;
    public int size;
    public class ListNode{
        public int val;
        public int id;
        public ListNode prev;
        public ListNode next;
        public ListNode(int id,int val){
            this.id=id;
            this.val=val;
            prev=null;
            next=null;
        }
    }
    public ListNode head;
    public ListNode tail;
    public HashMap<Integer,ListNode> mapLRU;
    public Solution(int capacity) {
        this.capacity=capacity;
        size=0;
        head=null;
        tail=null;
        mapLRU=new HashMap<Integer,ListNode>();
    }
    
    public int get(int key) {
        if(mapLRU.containsKey(key)){
            moveNodetoFirst(mapLRU.get(key));
            //System.out.println("size" + size);
            //printLRU();
            return mapLRU.get(key).val;
        }

        return -1;
    }
    
    public void set(int key, int value) {
        if(mapLRU.containsKey(key)){
            updateValue(key,value);
            moveNodetoFirst(mapLRU.get(key));
            //System.out.println("size" + size);
            //printLRU();
            return;
        }
        else if(size>=capacity){
            deleteTailNode();
        }
        addNewNode(key,value);
        //System.out.println("size" + size);
        //printLRU();
    }

    public void addNewNode(int key,int value){
        ListNode newNode=new ListNode(key,value);
        newNode.next=head;
        if(head!=null)
            head.prev=newNode;
        else
            tail=newNode;
        head=newNode;
        size++;
        mapLRU.put(key,newNode);
    }

    public void deleteTailNode(){
        mapLRU.remove(tail.id);
        tail=tail.prev;
        if(tail!=null)
            tail.next=null;
        else
            head=null;

        size--;
    }

    public void updateValue(int key,int value){
        if(mapLRU.containsKey(key)){
            mapLRU.get(key).val=value;
        }
    }

    public void moveNodetoFirst(ListNode mid){
        if(mid==head || mid==null)
            return;
        ListNode prev=mid.prev;
        ListNode next=mid.next;
        if(next==null){
            tail=prev;
            prev.next=null;
            mid.prev=null;
            mid.next=head;
            head.prev=mid;
            head=mid;
            //System.out.println("Set to head" + head.val);
            return;
        }
        
        prev.next=next;
        next.prev=prev;
        mid.prev=null;
        head.prev=mid;
        mid.next=head;
        head=mid;
        
    }
    public void printLRU(){
        ListNode temp=head;
        while(temp!=null){
            //System.out.print(temp.id +"-"+temp.val+", ");
            temp=temp.next;
        }
        //System.out.print(temp.id);
    }
}
