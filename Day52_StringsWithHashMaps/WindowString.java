public class Solution {
    public String minWindow(String A, String B) {
        int lenA=A.length();
        int lenB=B.length();
        HashMap<Character,Integer> mapB=new HashMap<Character,Integer>();

        if(lenA<lenB)
            return "";
        
        for(int i=0;i<lenB;i++){
            char currChar=B.charAt(i);
            if(mapB.containsKey(currChar))
                mapB.put(currChar,mapB.get(currChar)+1);
            else
                mapB.put(currChar,1);
        }
        int i=0,j=0;
        int reqChars=0;
        //int surplusChars=0;
        int minSoFar=lenA+1;
        int start=-1,end=lenA;

        for(;i<=(lenA-lenB);i++){
            while(reqChars<lenB && j<lenA){
                char a=A.charAt(j);
                if(mapB.containsKey(a) && mapB.get(a)>0){
                    mapB.put(a,mapB.get(a)-1);
                    reqChars++;
                }
                else if(mapB.containsKey(a)){
                    mapB.put(a,mapB.get(a)-1);
                    //surplusChars++;                    
                }
                j++;
            }
            //System.out.println("i and j"+i +"&"+ j);
            if(reqChars<lenB && j==lenA){
                if(start==-1 && end==-1)
                    return "";
                else
                    break;
            }
            else if((end-start)>(j-i)){
                end=j;
                start=i;
            }

            if(mapB.containsKey(A.charAt(i))){
                mapB.put(A.charAt(i),mapB.get(A.charAt(i))+1);
                if(mapB.get(A.charAt(i)) > 0)
                    reqChars--;
            }
        }

        if(start==-1)
            return "";
        return A.substring(start,end);
    }
}
