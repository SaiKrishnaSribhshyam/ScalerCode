public class Solution {
    public int[] sortColors(int[] A) {
        int len=A.length;
        int redsCount=0;
        int whitesCount=0;
        int bluesCount=0;

        for(int i=0;i<len;i++){
            if(A[i]==0)
                redsCount++;
            else if(A[i]==1)
                whitesCount++;
            else
                bluesCount++;
        }

        int i=0;
        while(i<redsCount){
            A[i]=0;
            i++;
        }
        whitesCount+=redsCount;
        while(i<whitesCount){
            A[i]=1;
            i++;
        }
        bluesCount+=whitesCount;
        while(i<bluesCount){
            A[i]=2;
            i++;
        }
        return A;

    }
}
