public class Solution {
    public int getPriority(char ch){
        if(ch=='^')
            return 5;
        else if(ch=='*'||ch=='/')
            return 4;
        else if(ch=='+'||ch=='-')
            return 3;
        else if(ch=='('||ch==')')
            return 2;
        else
            return 1;
    }
    public String solve(String A) {
        int length=A.length();
        StringBuilder postfix=new StringBuilder();
        Stack<Character> operators=new Stack();
        for(int i=0;i<length;i++){
            char ch=A.charAt(i);
            if(getPriority(ch)>1){
                if(ch==')'){
                    while(operators.size()>0 && operators.peek()!='(')
                        postfix.append(operators.pop());
                    operators.pop();
                }
                else if(ch=='(')
                    operators.push(ch);
                else{
                    while(operators.size()>0 && getPriority(operators.peek())>=getPriority(ch))
                        postfix.append(operators.pop());
                    operators.push(ch);
                }
                
            }
            else
                postfix.append(ch);
        }
        while(operators.size()>0){
            postfix.append(operators.pop());
        }
        return postfix.toString();
    }
}
