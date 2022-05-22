public class Solution {
    public class Trie {
        HashMap<Integer,Trie> map;
        public Trie() {
            this.map=new HashMap<Integer,Trie>();
        }
    }
    public void insert(Trie root,int num){
        Trie curr=root;
        for(int i=30;i>=0;i--){
            int currbit=((num>>i)&1);
            if(!curr.map.containsKey(currbit))
                curr.map.put(currbit,new Trie());
            curr=curr.map.get(currbit);
        }
    }
    public int getMaxXOR(Trie root,int num){
        Trie curr=root;
        int candidate=0;
        for(int i=30;i>=0;i--){
            int currbit=(num>>i)&1;
            int requiredbit=currbit^1;
            if(curr.map.containsKey(requiredbit)){
                candidate|=(requiredbit<<i);
                curr=curr.map.get(requiredbit);
            }
            else{
                candidate|=(currbit<<i);
                curr=curr.map.get(currbit);
            }
        }
        return candidate;
    }
    public int solve(int[] A) {
        int length=A.length;
        Trie root=new Trie();
        int maxXOR=0;
        for(int i=0;i<length;i++){
            insert(root,A[i]);
        }
        for(int i=0;i<length;i++){
            int candidate=getMaxXOR(root,A[i]);
            maxXOR=Math.max(maxXOR,A[i]^candidate);
        }
        return maxXOR;
    }
}
