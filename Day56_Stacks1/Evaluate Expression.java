public class Solution {
    public int evalRPN(String[] A) {
        int length=A.length;
        Stack<Integer> operands=new Stack();
        for(int i=0;i<length;i++){
            String ch=A[i];
            if(Character.isDigit(ch.charAt(ch.length()-1)))
                operands.push(Integer.parseInt(ch));
            else{
                int y=operands.pop();
                int x=operands.pop();
                switch(ch){
                    case "+":   operands.push(x+y);
                                break;
                    case "-":   operands.push(x-y);
                                break;
                    case "*":   operands.push(x*y);
                                break;
                    case "/":   operands.push(x/y);
                                break;
                }
            }
        }
        return operands.pop();
    }
}
