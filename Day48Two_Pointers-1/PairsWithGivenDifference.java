public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int len=A.length;
        int i=0;
        int j=1;
        int count=0;
        while(j<len&&i<j){
            if((A[j]-A[i])<B){
                j++;
            }
            else if((A[j]-A[i])>B){
                i++;
            }
            else{
                count++;
                i++;
                j++;
                while((i<len)&&(j<len)&&(A[i]==A[i-1])&&(A[j]==A[j-1])){
                    i++;
                    j++;
                }
            }

            if(i==j)
                j++;
        }

        return count;
    }
}
