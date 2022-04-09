public class Solution {
    public String solve(String A) {
        int length=A.length();
        int start=0;
        int end=length-1;
        int mismatches=0;
        while(start<end){
            if(A.charAt(start)!=A.charAt(end))
                mismatches++;
            start++;
            end--;
            if(mismatches>1)
                return "NO";
        }

        if(mismatches==0 && length%2==0)
            return "NO";
        
        return "YES";
    }
}
