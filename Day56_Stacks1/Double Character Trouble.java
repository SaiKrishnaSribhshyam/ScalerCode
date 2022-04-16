public class Solution {
    public String solve(String A) {
        int length=A.length();
        Stack<Character> singles=new Stack();
        for(int i=0;i<length;i++){
            if(singles.size()>0 && singles.peek()==A.charAt(i))
                singles.pop();
            else
                singles.push(A.charAt(i));
        }
        StringBuilder result=new StringBuilder();
        while(singles.size()>0){
            result.insert(0,singles.pop());
        }
        return result.toString();
    }
}
