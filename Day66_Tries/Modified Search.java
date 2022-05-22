public class Solution {
    public class Trie{
        HashMap<Character,Trie> map;
        boolean isEOW;
        public Trie(){
            map=new HashMap();
            isEOW=false;
        }
    }
    public void insert(Trie root,String str){
        Trie curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!curr.map.containsKey(ch))
                curr.map.put(ch,new Trie());
            curr=curr.map.get(ch);
        }
        curr.isEOW=true;
    }
    public int find(Trie root, String str){
        Trie curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!curr.map.containsKey(ch))
                return 0;
            curr=curr.map.get(ch);
        }
        if(curr.isEOW)
            return 1;
        return 0;
    }
    public int findWithWildcard(Trie root,String str,int start,int mismatch){
        if(root==null ||mismatch>1)
            return 0;
        if(start==str.length()){
            if(mismatch==1 && root.isEOW)
                return 1;
            else
                return 0;
        }
        for(char key:root.map.keySet()){
            char ch=str.charAt(start);
            int findIncluded=0,findExcluded=0;
            if(key==ch){
                findIncluded=findWithWildcard(root.map.get(key),str,start+1,mismatch);
            }
            else {
                findExcluded=findWithWildcard(root.map.get(key),str,start+1,mismatch+1);
            }

            if(findIncluded==1 || findExcluded==1)
                return 1;
        }
        return 0;
    }
    public String solve(ArrayList<String> A, ArrayList<String> B) {
        StringBuffer result=new StringBuffer();
        Trie root=new Trie();
        for(int i=0;i<A.size();i++)
            insert(root,A.get(i));
        for(int i=0;i<B.size();i++){
            int findResult=findWithWildcard(root,B.get(i),0,0);
            result.append(String.valueOf(findResult));
        }
        return result.toString();
    }
}
