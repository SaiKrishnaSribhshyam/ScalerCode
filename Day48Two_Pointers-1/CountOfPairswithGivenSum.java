public class Solution {
    public int solve(int[] A, int B) {
        int len=A.length;
        int low=0;
        int high=len-1;

        long pairsCount=0l;
        while(low<high){
            int currSum=A[low]+A[high];
            if(currSum<B)
                low++;
            else if(currSum>B)
                high--;
            else{
                pairsCount++;
                low++;
                high--;
            }
        }

        return (int)pairsCount;
    }
}
