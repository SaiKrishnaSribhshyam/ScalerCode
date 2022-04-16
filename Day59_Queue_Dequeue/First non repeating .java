public class Solution {
    public String solve(String A) {
        Queue<Character> chars=new LinkedList();
        HashMap<Character,Integer> charCounts=new HashMap();
        int length=A.length();
        StringBuilder result=new StringBuilder();

        for(int i=0;i<length;i++){
            char ch=A.charAt(i);
            if(charCounts.containsKey(ch))
                charCounts.put(ch,2);
            else{
                chars.add(ch);
                charCounts.put(ch,1);
            }
            
            while(chars.size()>0 && charCounts.get(chars.peek())>1)
                chars.poll();
            
            if(chars.size()==0)
                result.append('#');
            else
                result.append(chars.peek());
        }
        return result.toString();
    }
}
