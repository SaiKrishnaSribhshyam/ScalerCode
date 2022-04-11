public class Solution {
    public int solve(String A) {
        int length=A.length();
        int countA=0;
        int result=0;
        for(int i=0;i<length;i++){
            if(A.charAt(i)=='a'){
                countA++;
                result+=countA;
            }
        }
        //result=(result==0)?countA:
        return result;
    }
}
