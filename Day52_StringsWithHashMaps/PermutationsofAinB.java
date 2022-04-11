public class Solution {
    public boolean isMatch(HashMap<Character,Integer> mapA){
        for(Integer val:mapA.values()){
            if(val!=0)
                return false;
        }
        return true;
    }
    public int solve(String A, String B) {
        int lenA=A.length();
        int lenB=B.length();
        HashMap<Character,Integer> mapA=new HashMap();
        if(lenB<lenA)
            return 0;
        
        int count=0;

        for(int i=0;i<lenA;i++){
            char a=A.charAt(i);
            if(mapA.containsKey(a))
                mapA.put(a,mapA.get(a)+1);
            else
                mapA.put(a,1);
        }

        for(int i=0;i<lenA;i++){
            char b=B.charAt(i);
            if(mapA.containsKey(b))
                mapA.put(b,mapA.get(b)-1);
        }

        int j=lenA;
        for(int i=0;i<=(lenB-lenA);i++){
            if(isMatch(mapA))
                count++;
            if(j==lenB)
                break;
            char toRemove=B.charAt(i);
            char toAdd=B.charAt(j);
            if(mapA.containsKey(toRemove))
                mapA.put(toRemove,mapA.get(toRemove)+1);
            if(mapA.containsKey(toAdd))
                mapA.put(toAdd,mapA.get(toAdd)-1);
            j++;
        }

        return count;

    }
}
