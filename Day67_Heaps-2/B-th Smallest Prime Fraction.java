public class Solution {
    public class FractionCompare implements Comparator<int[]> {
        public int compare(int[] f1,int[] f2){
            double val1=(f1[0]*1d)/(f1[1]*1d);
            double val2=(f2[0]*1d)/(f2[1]*1d);
            if(val1>val2)
                return 1;
            else if(val1<val2)
                return -1;
            
            return 0;
        }
    }
    public int[] solve(int[] A, int B) {
        PriorityQueue<int[]> minHeap=new PriorityQueue(new FractionCompare());
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                int[] fraction={A[i],A[j]};
                minHeap.offer(fraction);
            }
        }

        for(int i=0;i<B-1;i++)
            minHeap.poll();
        
        return minHeap.poll();
    }
}
