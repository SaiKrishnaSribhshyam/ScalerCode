public class Solution {
    public int[] nextGreater(int[] A) {
        int length=A.length;
        Stack<Integer> currBig=new Stack<Integer>();
        int[] nextBig=new int[length];

        for(int i=length-1;i>=0;i--){
            while(currBig.size()>0 && currBig.peek()<=A[i]){
                currBig.pop();
            }
            if(currBig.size()>0)
                nextBig[i]=currBig.peek();
            else
                nextBig[i]=-1;
            
            currBig.push(A[i]);
        }
        return nextBig;
    }
}
