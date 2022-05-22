public class Solution {
    public int solve(int[][] A, int B) {
        PriorityQueue<Integer> minHeap=new PriorityQueue();
        int N=A.length;
        int M=A[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                minHeap.offer(A[i][j]);
            }
        }
        for(int i=0;i<B-1;i++)
            minHeap.poll();
        
        return minHeap.poll();
    }
}
