public class Solution {
    public String smallestPrefix(String A, String B) {
        StringBuffer charRanks=new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        StringBuffer prefix=new StringBuffer();
        prefix.append(A.charAt(0));
        int lengthA=A.length();
        int lengthB=B.length();
        int i=1;
        while((i<lengthA) && charRanks.indexOf(A.substring(i,i+1))<charRanks.indexOf(B.substring(0,1))){
            prefix.append(A.charAt(i));
            //System.out.println(i);
            i++;
        }
        prefix.append(B.charAt(0));
        return prefix.toString();
    }
}
