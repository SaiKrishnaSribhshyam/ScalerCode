public class Solution {
    public int solve(int[] A) {
        int len=A.length;
        HashSet<Long> uniquePrefixSums=new HashSet();
        long sum=0l;
        uniquePrefixSums.add(sum);
        for(int i=0;i<len;i++){ 
            sum +=A[i];
            if(uniquePrefixSums.contains(sum))
                return 1;
            else
                uniquePrefixSums.add(sum);
        }
        return 0;
    }
}
