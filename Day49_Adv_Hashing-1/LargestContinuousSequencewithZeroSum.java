public class Solution {
    public int[] lszero(int[] A) {
        int len=A.length;
        long sum=0l;
        HashMap<Long,Integer> lastPSIndex=new HashMap<Long,Integer>();
        lastPSIndex.put(sum,0);
        int maxLength=-1;
        int[] maxIndex=new int[2];
        maxIndex[0]=-1;
        maxIndex[1]=-1;
        for(int i=0;i<len;i++){
            sum+=A[i];
            if(lastPSIndex.containsKey(sum)){
                if((i-lastPSIndex.get(sum))>maxLength){
                    maxIndex[0]=lastPSIndex.get(sum);
                    maxIndex[1]=i;
                    maxLength=maxIndex[1]-maxIndex[0];
                }
            }
            else{
                lastPSIndex.put(sum,i+1);
            }
        }

        if(maxIndex[0]==-1){
            int[] result={};
            return result;
        }

        int[] sequence=new int[maxIndex[1]-maxIndex[0]+1];
        int j=maxIndex[0];
        //j=Math.max(j,0);
        for(int i=0;i<sequence.length;i++){
            sequence[i]=A[j];
            j++;
        }

        return sequence;
    }
}
