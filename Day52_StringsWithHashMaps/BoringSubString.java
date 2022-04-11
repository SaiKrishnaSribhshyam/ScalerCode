public class Solution {
    public int solve(String A) {
        int length=A.length();
        StringBuffer odd=new StringBuffer("");
        StringBuffer even=new StringBuffer("");

        for(int i=0;i<length;i++){
            char ch=A.charAt(i);
            String key=new String(ch+"");
            if(ch%2==0){
                if(even.indexOf(key)==-1)
                    even.append(ch);
            }
            else{
                if(odd.indexOf(key)==-1)
                    odd.append(ch);
            }
        }

        if(even.length()==1 || odd.length()==1){
            if(Math.abs(even.charAt(0)-odd.charAt(odd.length()-1))==1 && Math.abs(even.charAt(even.length()-1)-odd.charAt(0))==1)
                return 0;
        }

        return 1;
    }
}
