public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int lenA=A.length;
        int lenB=B.length;
        int lenC=C.length;

        int minimizedDiff=Integer.MAX_VALUE;
        int i=0,j=0,k=0;
        while(i<lenA && j<lenB && k<lenC){
            int min=Math.min(A[i],B[j]);
            min=Math.min(min,C[k]);
            int localmax=-1;

            while(i<lenA && A[i]<min)
                i++;
            while(j<lenB && B[j]<min)
                j++;
            while(k<lenC && C[k]<min)
                k++;
            i=Math.min(i,lenA-1);
            j=Math.min(j,lenB-1);
            k=Math.min(k,lenC-1);

            localmax=Math.max(localmax,Math.abs(A[i]-B[j]));
            localmax=Math.max(localmax,Math.abs(C[k]-B[j]));
            localmax=Math.max(localmax,Math.abs(A[i]-C[k]));
            minimizedDiff=Math.min(minimizedDiff,localmax);
            if(A[i]==min)
                i++;
            if(B[j]==min)
                j++;
            if(C[k]==min)
                k++;
        }
        return minimizedDiff;
    }
}
