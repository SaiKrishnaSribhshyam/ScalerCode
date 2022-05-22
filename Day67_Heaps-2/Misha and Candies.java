public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> minHeap=new PriorityQueue();
        for(int candies:A)
            minHeap.offer(candies);
        long consumedCandies=0;
        boolean maxReached=false;
        while(minHeap.size()>1){
            int minBox=minHeap.poll();
            if(minBox>B){
               maxReached=true;
               break;
            }
            int consumed=minBox/2;
            consumedCandies+=consumed;
            minBox=minBox-consumed;
            int nextBox=minHeap.poll();
            minHeap.offer(nextBox+minBox);
        }
        
        if(!maxReached){
            int candies=minHeap.poll();
            if(candies<B)
                consumedCandies+=candies/2;
        }

        return (int)consumedCandies;
    }
}
