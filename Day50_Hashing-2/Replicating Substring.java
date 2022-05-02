public class Solution {
    public int solve(int A, String B) {
        int len=B.length();
        HashMap<Character,Integer> charCounts=new HashMap();

        for(int i=0;i<len;i++){
            char ch=B.charAt(i);
            if(charCounts.containsKey(ch))
                charCounts.put(ch,charCounts.get(ch)+1);
            else
                charCounts.put(ch,1);
        }

        for(Map.Entry<Character,Integer> entry:charCounts.entrySet()){
            if(entry.getValue()%A!=0)
                return -1;
        }

        return 1;
    }
}
