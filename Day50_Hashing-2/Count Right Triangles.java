public class Solution {
    public int solve(int[] A, int[] B) {
        int len=A.length;
        HashMap<Integer,Integer> countofX=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> countofY=new HashMap<Integer,Integer>();
        long trianglesCount=0l;
        long mod=(long)Math.pow(10,9)+7;

        //getting frequency of xand Y co-ordinates
        for(int i=0;i<len;i++){
            if(countofX.containsKey(A[i]))
                countofX.put(A[i],countofX.get(A[i])+1);
            else
                countofX.put(A[i],1);
            
            if(countofY.containsKey(B[i]))
                countofY.put(B[i],countofY.get(B[i])+1);
            else
                countofY.put(B[i],1);
        }

        //counting triangles
        for(int i=0;i<len;i++){
            int m=countofX.get(A[i])-1;
            int n=countofY.get(B[i])-1;
            trianglesCount=(trianglesCount+(m%mod*n%mod)%mod)%mod;
        }
        return (int)trianglesCount;
    }
}
