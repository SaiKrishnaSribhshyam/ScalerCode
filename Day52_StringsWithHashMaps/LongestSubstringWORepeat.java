public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int length=A.length();
        HashSet<Character> subStringChars=new HashSet();
        int i=0;
        int maxLengthSoFar=-1;
        for(int j=0;j<length;j++){
            char currentChar=A.charAt(j);
            while(subStringChars.contains(currentChar)){
                subStringChars.remove(A.charAt(i));
                i++;
            }
            subStringChars.add(currentChar);
            maxLengthSoFar=Math.max(maxLengthSoFar,subStringChars.size());
        }
        return maxLengthSoFar;
    }
}
