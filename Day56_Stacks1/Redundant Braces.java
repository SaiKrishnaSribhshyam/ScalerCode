public class Solution {
    public int braces(String A) {
        Stack<Character> braces=new Stack();
        int length=A.length();
        for(int i=0;i<length;i++){
            char ch=A.charAt(i);
            if(ch==')' && braces.size()>0){
                int subExpressionCount=0;
                while(braces.size()>0 && braces.peek()!='('){
                    braces.pop();
                    subExpressionCount++;
                }
                if(subExpressionCount<=1)
                    return 1;
                braces.pop();
            }
            else{
                braces.push(ch);
            }
        }
        return 0;
    }
}
