public class Solution {
    public int solve(int[] A, int B) {
        int len=A.length;
        long mod=(long)Math.pow(10,9)+7;
        long result=0l;
        int i=0,j=len-1;
        int previ=-1,prevj=-1;
        if(i==j && A[i]*A[j]<B)
            return 1;
        while(i<j){
            if(i!=previ && ((long)A[i]*(long)A[i]*1l)<(B))
                result=(result+1)%mod;
            if(j!=prevj && ((long)A[j]*(long)A[j]*1l)<(B))
                result=(result+1)%mod;
            previ=i;
            prevj=j;
            if(((long)A[i]*(long)A[j]*1l) <(B)){
                result=(result+(j-i)*2)%mod;
                i++;
            }
            else
                j--;
            //System.out.println((long)99974*(long)99974*1L);
        }
        return (int)(result%mod);
    }
}
