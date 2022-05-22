public class Solution {
    public class Trie{
        HashMap<Character,Trie> map=new HashMap();
        boolean isEOW=false;
    }
    public int[] solve(String[] A, String[] B) {
        int length=A.length;
        Trie root=new Trie();
        int[] result=new int[B.length];
        for(int i=0;i<length;i++){
            Trie curr=root;
            for(int j=0;j<A[i].length();j++){
                char ch=A[i].charAt(j);
                if(curr!=null && curr.map.containsKey(ch))
                    curr=curr.map.get(ch);
                else{
                    curr.map.put(ch,new Trie());
                    curr=curr.map.get(ch);
                }
            }
            curr.isEOW=true;
        }

        for(int i=0;i<B.length;i++){
            Trie curr=root;
            boolean isFound=true;
            for(int j=0;j<B[i].length();j++){
                char ch=B[i].charAt(j);
                if(!curr.map.containsKey(ch)){
                    isFound=false;
                    break;
                }
                else
                    curr=curr.map.get(ch);
            }
            if(isFound && curr.isEOW)
                result[i]=1;
            else
                result[i]=0;
        }

        return result;
    }
}
