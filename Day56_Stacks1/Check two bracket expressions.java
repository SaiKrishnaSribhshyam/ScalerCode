public class Solution {
    public int evalSign(int local,boolean global){
        int resolvedSign=0;
        if((local==1||local==0) && global==false)
            resolvedSign=1;
        else if((local==1||local==0) && global==true)
            resolvedSign=-1;
        else if(local==-1 && global==false)
            resolvedSign=-1;
        else if(local==-1 && global==true)
            resolvedSign=1;

        return resolvedSign;
    }
    public int[] flatten(String A){
        int[] operands=new int[26];
        Stack<Boolean> globalSign=new Stack();
        int lastSign=0;
        globalSign.push(false);
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(ch=='('){
                if(lastSign==-1)
                    globalSign.push(!globalSign.peek());
                else
                    globalSign.push(globalSign.peek());
                lastSign=0;
            }
            else if(ch==')'){
                globalSign.pop();
                lastSign=0;
            }
            else if(ch=='+')
                lastSign=1;
            else if(ch=='-')
                lastSign=-1;
            else{
                int index=ch-'a';
                operands[index]=evalSign(lastSign,globalSign.peek());
                lastSign=0;
            }
        }
        return operands;
    }
    public int solve(String A, String B) {
        if(A.equals(B))
            return 1;
        int[] charMapA=flatten(A);
        int[] charMapB=flatten(B);

        for(int i=0;i<26;i++){
            if(charMapA[i]!=charMapB[i])
                return 0;
        }


        return 1;
    }
}
