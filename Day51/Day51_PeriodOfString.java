public class Solution {
    public int solve(String A) {
        int len=A.length();
        int period=-1;
        int i=0;
        for(int j=1;j<len;j++){
            int currChar=A.charAt(j);
            int comparator=A.charAt(i);

            if(currChar==comparator){
                period=(j-i);
                i++;
            }
            else{
                period=-1;
                if(currChar==A.charAt(0)){
                    i=1;
                    period=j;
                }
                else
                    i=0;
            }
        }

        period=(period==-1)?len:period;
        return period;
    }
}
