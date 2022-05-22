public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        long result=0;
        for(int e:A)
            minHeap.offer(e);
        for(int i=0;i<B;i++){
            int min=minHeap.poll();
            minHeap.offer(min*-1);
        }
        while(minHeap.size()>0){
            result+=minHeap.poll();
        }
        return (int)result;
    }
}
