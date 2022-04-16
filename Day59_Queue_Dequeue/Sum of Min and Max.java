public class Solution {
    public int solve(int[] A, int B) {
        int length=A.length;
        long result=0l;
        long mod=(long)Math.pow(10,9)+7;
        Deque<Integer> minSofar=new LinkedList();
        Deque<Integer> maxSofar=new LinkedList();
        for(int i=0;i<B;i++){
            while(minSofar.size()>0 && minSofar.peekLast()>A[i])
                minSofar.pollLast();
            minSofar.offerLast(A[i]);

            while(maxSofar.size()>0 && maxSofar.peekLast()<A[i])
                maxSofar.pollLast();
            maxSofar.offerLast(A[i]);
        }
        result=minSofar.peekFirst()+maxSofar.peekFirst();
        int j=B;
        for(int i=1;i<=(length-B);i++){
            if(minSofar.size()>0 && minSofar.peekFirst()==A[i-1])
                minSofar.pollFirst();
            if(maxSofar.size()>0 && maxSofar.peekFirst()==A[i-1])
                maxSofar.pollFirst();

            while(minSofar.size()>0 && minSofar.peekLast()>A[j])
                minSofar.pollLast();
            minSofar.offerLast(A[j]);

            while(maxSofar.size()>0 && maxSofar.peekLast()<A[j])
                maxSofar.pollLast();
            maxSofar.offerLast(A[j]);  

            result=(result+minSofar.peekFirst()+maxSofar.peekFirst())%mod;
            j++;
        }
        if(result<0)
            result=result+mod;
        return (int)(result%mod);
    }
}
