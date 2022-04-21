public class Solution {
    public int[] solve(int[] A, int B) {
        int len=A.length;
        int start=0;
        int end=0;
        int sum=A[end];
        boolean sumexists=false;
       while((end<len)&&(start<len)){
           if(sum<B){
                end++;
                if(end<len)
                    sum+=A[end];
           }
           else if(sum>B){
               sum-=A[start];
               start++;
           }
           else{
               sumexists=true;
               break;
           }
       }

       
       if(!sumexists){
           int[] result={-1};
           return result;
       }

        int[] result=new int[end-start+1];
        int j=0;
        for(int i=start;i<=end;i++){
            result[j]=A[i];
            j++;
        }

        return result;

    }
}
