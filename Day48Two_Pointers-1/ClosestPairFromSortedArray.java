public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int lenA=A.length;
        int lenB=B.length;
        int[] closestPair=new int[2];
        long minimumDiff=Integer.MAX_VALUE;

        int i=0,j=lenB-1;

        while(i<lenA && j>=0){

            if(Math.abs((A[i]+B[j])-C)<minimumDiff || ((Math.abs((A[i]+B[j])-C)==minimumDiff) && (closestPair[0]==A[i])) ){
                minimumDiff=Math.abs((A[i]+B[j])-C);
                closestPair[0]=A[i];
                closestPair[1]=B[j];
            }

            if((A[i]+B[j])>C)
                j--;
            else if((A[i]+B[j])<C)
                i++;
            else    
                break;
        }

        return closestPair;
    }
}
