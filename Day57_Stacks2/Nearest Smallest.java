public class Solution {
    public int[] prevSmaller(int[] A) {
        int length=A.length;
        Stack<Integer> nearestSmall=new Stack();
        int[] nearestElements=new int[length];
        nearestElements[0]=-1;
        nearestSmall.push(A[0]);
        for(int i=1;i<length;i++){
            if(A[i]>nearestSmall.peek()){
                nearestElements[i]=nearestSmall.peek();
                nearestSmall.push(A[i]);
            }
            else{
                while(nearestSmall.size()>0 && nearestSmall.peek()>=A[i]){
                    nearestSmall.pop();
                }
                if(nearestSmall.size()>0){
                    nearestElements[i]=nearestSmall.peek();
                }
                else
                    nearestElements[i]=-1;
                nearestSmall.push(A[i]);
            }
        }
        return nearestElements;
    }
}
