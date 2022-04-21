public class Solution {
    public int maxArea(int[] A) {
        int low=0;
        int high=A.length-1;
        int maxArea=0;

        while(low<high){
            maxArea=Math.max(Math.min(A[low],A[high])*(high-low),maxArea);
            if(A[low]<A[high])
                low++;
            else if(A[low]>A[high])
                high--;
            else{
                low++;
                high--;
            }

        }
        return maxArea;
    }
}
