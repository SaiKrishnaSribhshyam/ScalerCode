public class Solution {
    public int solve(int[] A, int[] B, int[] C) {
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

            localmax=Math.max(B[j],A[i]);
            localmax=Math.max(localmax,C[k]);
            minimizedDiff=Math.min(minimizedDiff,Math.abs(localmax-min));
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
