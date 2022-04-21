public class Solution {
    public int getRequiredSum(int[] A,int start,int end,int sum){
        long requiredSum=Integer.MAX_VALUE;
        while(start<end){
            if((A[start]+A[end])>sum)
                end--;
            else if((A[start]+A[end])<sum)
                start++;
            else
                return A[start]+A[end];
            if(Math.abs(requiredSum-sum)>Math.abs(sum-A[start]+A[end]))
                requiredSum=A[start]+A[end];
            //System.out.println(Math.abs(requiredSum-sum) +":"+ Math.abs(sum-A[start]+A[end]));
        }
        return (int)requiredSum;
    }
    public int threeSumClosest(int[] A, int B) {
        int length=A.length;
        long closestSumSoFar=Integer.MAX_VALUE;
        if(length<4){
            int sum=0;
            for(int i=0;i<length;i++)
                sum+=A[i];
            return sum;
        }
        Arrays.sort(A);
        for(int i=0;i<length-2;i++){
            int requiredSum=(B-A[i]);
            int availableSum=getRequiredSum(A,i+1,length-1,requiredSum);
            if(Math.abs(closestSumSoFar-B)>Math.abs(B-(A[i]+availableSum))){
                closestSumSoFar=A[i]+availableSum;
            }
        }
        return (int)closestSumSoFar;
    }
}
