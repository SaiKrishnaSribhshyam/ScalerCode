public class Solution {
    public class distance implements Comparator<int[]>{
        public int compare(int[] point1,int[] point2){
            return (point1[0]*point1[0]+point1[1]*point1[1])-(point2[0]*point2[0]+point2[1]*point2[1]);
        }
    }
    public int[][] solve(int[][] A, int B) {
        PriorityQueue<int[]> minHeap=new PriorityQueue(new distance());
        int[][] result=new int[B][2];
        for(int[] point:A)
            minHeap.offer(point);
        
        for(int i=0;i<B;i++){
            result[i]=minHeap.poll();
        }
        return result;
    }
}
