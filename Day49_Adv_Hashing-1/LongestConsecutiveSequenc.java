public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        int len=A.length;
        HashSet<Integer> allElements=new HashSet();
        int maxSoFar=0;
        int thisSeqLength=0;
        for(int i=0;i<len;i++)
            allElements.add(A[i]);
        
        for(int i=0;i<len;i++){
            if(!allElements.contains(A[i]-1)){
                thisSeqLength=1;
                int nextElement=A[i]+1;
                while(allElements.contains(nextElement)){
                    thisSeqLength++;
                    nextElement++;
                }
                maxSoFar=Math.max(thisSeqLength,maxSoFar);
            }

        }
        return maxSoFar;
    }
}
