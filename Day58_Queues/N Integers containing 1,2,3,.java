public class Solution {
    public void enque(Queue<Integer> q){
        int base;
        base=(q.size()==0)?0:q.peek();
        for(int i=1;i<=3;i++){
            q.offer(base*10+i);
        }
    }
    public int[] solve(int A) {
        int[] firstASpecialNumbers=new int[A];
        Queue<Integer> speacialNums=new LinkedList();
        enque(speacialNums);
        for(int i=0;i<A;i++){
            if((speacialNums.size()+i)<A)
                enque(speacialNums);
            firstASpecialNumbers[i]=speacialNums.poll();
        }

        return firstASpecialNumbers;
    }
}
