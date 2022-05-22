public class Solution {
    public class Trie{
        HashMap<Character,Trie> map;
        boolean isEOW;
        int count;
        public Trie(){
            map=new HashMap();
            isEOW=false;
            count=0;
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
            curr.count++;
        }
        curr.isEOW=true;
    }

    public int find(Trie root,String str){
        Trie curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!curr.map.containsKey(ch))
                return 0;
            curr=curr.map.get(ch);
        }
        return curr.count;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        Trie root=new Trie();
        ArrayList<Integer> finds=new ArrayList();
        for(int i=0;i<A.size();i++){
            int operation=A.get(i);
            if(operation==0){
                insert(root,B.get(i));
            }
            else if(operation==1){
                finds.add(find(root,B.get(i)));
            }
        }
        return finds;
    }
}
