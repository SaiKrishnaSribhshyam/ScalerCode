public class Solution {
    public int solve(int[] A) {
        int length=A.length;
        int[] leftmin=new int[length];
        int[] leftmax=new int[length];
        Stack<Integer> minStack=new Stack();
        Stack<Integer> maxStack=new Stack();
        long result=0l;
        long mod=(long)Math.pow(10,9)+7;

        for(int i=0;i<length;i++){
            while(minStack.size()>0 && A[minStack.peek()]>A[i]){
                minStack.pop();
            }
            while(maxStack.size()>0 && A[maxStack.peek()]<A[i]){
                maxStack.pop();
            }
            if(minStack.size()>0)
                leftmin[i]=minStack.peek();
            else
                leftmin[i]=-1;
            minStack.push(i);

            if(maxStack.size()>0)
                leftmax[i]=maxStack.peek();
            else
                leftmax[i]=-1;
            maxStack.push(i);
        }

        minStack.clear();
        maxStack.clear();
        int[] rightmin=new int[length];
        int[] rightmax=new int[length];

        for(int i=length-1;i>=0;i--){
            while(minStack.size()>0 && A[minStack.peek()]>=A[i])
                minStack.pop();
            if(minStack.size()>0)
                rightmin[i]=minStack.peek();
            else
                rightmin[i]=-1;
            
            minStack.push(i);

            while(maxStack.size()>0 && A[maxStack.peek()]<=A[i])
                maxStack.pop();
            if(maxStack.size()>0)
                rightmax[i]=maxStack.peek();
            else
                rightmax[i]=-1;
            
            maxStack.push(i);
        }

        for(int i=0;i<length;i++){
            long maxContribution,minContribution;
            int rightMaxIndex=(rightmax[i]==-1)?length:rightmax[i];
            int rightMinIndex=(rightmin[i]==-1)?length:rightmin[i];
            maxContribution=((i-leftmax[i])*1L*(rightMaxIndex-i));
            minContribution=((i-leftmin[i])*1L*(rightMinIndex-i));
            result=(result+((maxContribution-minContribution)*A[i])%mod)%mod;
            if(result<0)
                result=result+mod;
            //System.out.println(A[i]+":"+leftmin[i] +","+rightmin[i]+","+leftmax[i]+","+rightmax[i]);
        }
        if(result<0)
            result=result+mod;
        return (int)(result%mod);

    }
}
