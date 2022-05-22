public class Solution {
    public class Trie{
        HashMap<Character,Trie> map;
        boolean isEOW;
        public Trie(){
            this.map=new HashMap<Character,Trie>();
            this.isEOW=false;
        }
    }
    public void insert(Trie root,String str){
        Trie curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!curr.map.containsKey(ch)){
                curr.map.put(ch,new Trie());
            }
            curr=curr.map.get(ch);
        }
        curr.isEOW=true;
    }
    public String getUniquePrefix(Trie root,String str){
        Trie curr=root;
        int endIndex=1;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(curr.isEOW==true) 
                endIndex=i;
            else if(curr.map.size()>1)
                endIndex=i+1;
            curr=curr.map.get(ch);
        }
        return str.substring(0,endIndex);
    }
    public String[] prefix(String[] A) {
        int length=A.length;
        String[] prefix=new String[length];
        Trie root=new Trie();
        for(int i=0;i<length;i++){
            insert(root,A[i]);
        }

        for(int i=0;i<length;i++){
            prefix[i]=getUniquePrefix(root,A[i]);
        }
        return prefix;
    }
}
