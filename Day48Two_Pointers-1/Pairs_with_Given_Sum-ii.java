public class Solution {
    public int solve(int[] A, int B) {
        int len=A.length;
        int low=0;
        int high=len-1;
        long sum=0l;
        long mod=(long)Math.pow(10,9)+7;

        while(low<high){
            long currSum=A[low]+A[high];
            if(currSum<B){
                low++;
            }
            else if(currSum>B){
                high--;
            }
            else{
                if(low<high && A[low]==A[high]){
                    long pairs=(long)((((long)high-(long)low+1)*((long)high-(long)low))/2)%mod;
                    sum=(sum+pairs%mod)%mod;
                    break;
                }
                long pairs=1l;
                while(low<high && A[low+1]==A[low] && A[high-1]==A[high]){
                    pairs=(pairs+1)%mod;
                    low++;
                    high--;
                }
                sum=(sum+(pairs*pairs)%mod)%mod;
                while(low<high && A[low+1]==A[low]){
                    sum=(sum+pairs)%mod;
                    low++;
                }
                while(low<high && A[high-1]==A[high]){
                    sum=(sum+pairs)%mod;
                    high--;
                }
                low++;
                high--;

            }
        }
        return (int)(sum%mod);
    }
}
