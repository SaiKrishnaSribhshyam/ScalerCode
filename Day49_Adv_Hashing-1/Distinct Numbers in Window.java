public class Solution {
    public int[] dNums(int[] A, int B) {
        int len=A.length;
        if(B>len){
            int[] empty={};
            return empty;
        } 
        int i;
        HashMap<Integer,Integer> distinctElements=new HashMap();
        int[] distinctsCount=new int[len-B+1];
        for( i=0;i<B;i++){
            if(distinctElements.containsKey(A[i]))
                distinctElements.put(A[i],distinctElements.get(A[i])+1);
            else
                distinctElements.put(A[i],1);
        }
        distinctsCount[0]=distinctElements.size();

        for(int j=1;j<=len-B;j++){
            if(distinctElements.get(A[j-1])==1)
                distinctElements.remove(A[j-1]);
            else
                distinctElements.put(A[j-1],distinctElements.get(A[j-1])-1);

            if(distinctElements.containsKey(A[i]))
                distinctElements.put(A[i],distinctElements.get(A[i])+1);
            else
                distinctElements.put(A[i],1);
            distinctsCount[j]=distinctElements.size();
            i++;
        }

        return distinctsCount;
    }
}
