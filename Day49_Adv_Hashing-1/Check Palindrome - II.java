public class Solution {
    public int solve(String A) {
        int len=A.length();
        HashMap<Character,Integer> charCounts=new HashMap();

        for(int i=0;i<len;i++){
            char ch=A.charAt(i);
            if(charCounts.containsKey(ch))
                charCounts.put(ch,charCounts.get(ch)+1);
            else
                charCounts.put(ch,1);
        }
        int oddsCount=0;
        for(Integer val:charCounts.values()){
            if(val%2==1)
                oddsCount++;
        }

        if(oddsCount>1)
            return 0;
        
        return 1;
    }
}
