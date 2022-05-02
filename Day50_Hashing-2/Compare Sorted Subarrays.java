public class Solution {
        public long genRandomNumber(){
            long min=Integer.MAX_VALUE;
            long max=Long.MAX_VALUE;
            long range=max-min;
            Random rand=new Random();
            long randomNum=rand.nextLong()+min;
            return randomNum;
        }

        public HashMap<Integer,Long> getHashCodes(int[] A){
            HashMap<Integer,Long> hashCodes=new HashMap();
            int length=A.length;
            for(int i=0;i<length;i++){
                hashCodes.put(A[i],genRandomNumber());
            }
            return hashCodes;
        }

        
    public int[] solve(int[] A, int[][] B) {
        int length=A.length;
        int queries=B.length;
        HashMap<Integer,Long> hashCodes=getHashCodes(A);
        long[] prefixSum=new long[length+1];
        prefixSum[0]=0;
        for(int i=1;i<=length;i++){
            prefixSum[i]=prefixSum[i-1]+hashCodes.get(A[i-1]);
        }
        int[] results=new int[queries];
        for(int i=0;i<queries;i++){
            int l1=B[i][0];
            int r1=B[i][1];
            int l2=B[i][2];
            int r2=B[i][3];

            long sum1=prefixSum[r1+1]-prefixSum[l1];
            long sum2=prefixSum[r2+1]-prefixSum[l2];
            if(sum1==sum2)
                results[i]=1;
            else
                results[i]=0;
        }

        return results;

    }
}
