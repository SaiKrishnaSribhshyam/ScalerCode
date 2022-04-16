public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> maxCandidates=new LinkedList();
        int length=A.length;
        maxCandidates.add(A[0]);
        
        for(int i=1;i<Math.min(B,length);i++){
            if(A[i]<=maxCandidates.peekLast())
                maxCandidates.offerLast(A[i]);
            else{
                while(maxCandidates.size()>0 && maxCandidates.peekLast()<A[i])
                    maxCandidates.pollLast();
                maxCandidates.offerLast(A[i]);
            }
            
        }
        if(B>=length){
            int[] result=new int[1];
            result[0]=maxCandidates.peekFirst();
            return result;
        }
        int[] result=new int[length-B+1];
        result[0]=maxCandidates.peekFirst();
        int j=B;
        for(int i=1;i<=(length-B);i++){
            if(maxCandidates.size()>0 && maxCandidates.peekFirst()==A[i-1])
                maxCandidates.pollFirst();

            if(maxCandidates.size()>0 && A[j]<=maxCandidates.peekLast())
                maxCandidates.offerLast(A[j]);
            else{
                while(maxCandidates.size()>0 && maxCandidates.peekLast()<A[j])
                    maxCandidates.pollLast();
                maxCandidates.offerLast(A[j]);
            }
            result[i]=maxCandidates.peekFirst();
            j++;
        }
        return result;
    }
}
