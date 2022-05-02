public class Solution {
    public int[] solve(int[] A, int[] B) {
        int lengthA=A.length;
        int lengthB=B.length;
        ArrayList<Integer> commonElements=new ArrayList();
        HashMap<Integer,Integer> mapAFrequency=new HashMap();
        for(int i=0;i<lengthA;i++){
            if(mapAFrequency.containsKey(A[i]))
                mapAFrequency.put(A[i],mapAFrequency.get(A[i])+1);
            else
                mapAFrequency.put(A[i],1);
        }

        for(int i=0;i<lengthB;i++){
            if(mapAFrequency.containsKey(B[i])){
                commonElements.add(B[i]);
                mapAFrequency.put(B[i],mapAFrequency.get(B[i])-1);
                if(mapAFrequency.get(B[i])==0)
                    mapAFrequency.remove(B[i]);
            }
        }
        int[] common=new int[commonElements.size()];
        for(int i=0;i<commonElements.size();i++)
            common[i]=commonElements.get(i);



        return common;
    }
}
