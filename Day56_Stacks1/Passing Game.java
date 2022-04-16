public class Solution {
    public int solve(int A, int B, int[] C) {
        Stack<Integer> ballPredictor=new Stack<Integer>();
        ballPredictor.push(B);
    
        for(int i=0;i<A;i++){
            if(C[i]==0){
                ballPredictor.pop();
            }
            else
                ballPredictor.push(C[i]);
        }
        return ballPredictor.peek();
    }
}
