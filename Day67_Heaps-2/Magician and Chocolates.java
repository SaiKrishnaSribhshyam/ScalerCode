public class Solution {
    public int nchoc(int A, int[] B) {
        PriorityQueue<Long> maxHeap=new PriorityQueue(Collections.reverseOrder());
        int mod=(int)Math.pow(10,9)+7;
        for(long chocolates:B)
            maxHeap.offer((Long)chocolates);
        long kidChocs=0;
        for(int i=0;i<A;i++){
            long maxChocs=maxHeap.poll();
            kidChocs=(kidChocs+maxChocs)%mod;
            maxHeap.offer(maxChocs/2);
        }
        if(kidChocs<0)
            kidChocs=kidChocs+mod;
        return (int)(kidChocs%mod);
    }
}
