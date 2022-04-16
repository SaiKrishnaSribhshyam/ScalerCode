public class Solution {
    public boolean isMatch(char stringlet,char popper){
        if((stringlet==')' && popper=='(') || (stringlet==']'&& popper=='[') || (stringlet=='}'&&popper=='{'))
            return true;
        
        return false;
    }
    public int solve(String A) {
        Stack<Character> parenthesis=new Stack();
        int length=A.length();

        for(int i=0;i<length;i++){
            char thischar=A.charAt(i);
            if(thischar=='('||thischar=='{' ||thischar=='[')
                parenthesis.push(thischar);
            else{
                if(parenthesis.size()>0 && isMatch(thischar,parenthesis.pop()))
                    continue;
                else
                    return 0;
            }
        }

        if(parenthesis.size()>0)
            return 0;

        return 1;
    }
}
