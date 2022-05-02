public class Solution {
    public int solve(int[] A) {
        int len=A.length;
        int minDistance=len+1;
        HashMap<Integer,Integer> lastIndex=new HashMap();

        for(int i=0;i<len;i++){
            if(lastIndex.containsKey(A[i])){
                minDistance=Math.min(minDistance,i-lastIndex.get(A[i]));
            }
            lastIndex.put(A[i],i);
        }

        if(minDistance==len+1)
            return -1;
        
        return minDistance;
    }
}
