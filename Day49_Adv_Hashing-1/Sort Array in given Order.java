public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int lenA=A.size();
        int lenB=B.size();
        HashMap<Integer,Integer> orderMapA=new HashMap();

        for(Integer e:A){
            if(orderMapA.containsKey(e))
                orderMapA.put(e,orderMapA.get(e)+1);
            else
                orderMapA.put(e,1);
        }

        ArrayList<Integer> relativeOrder=new ArrayList();
        ArrayList<Integer> sortOrder=new ArrayList();
        for(Integer b:B){
            if(orderMapA.containsKey(b)){
                int freq=orderMapA.get(b);
                while(freq>0){
                    relativeOrder.add(b);
                    freq--;
                }
                orderMapA.remove(b);
            }
        }

        orderMapA.forEach((k,v)->{
            while(v>0){
                sortOrder.add(k);
                v--;
            }
        });
        Collections.sort(sortOrder);

        for(Integer e:sortOrder)
            relativeOrder.add(e);

        return relativeOrder;
    }
}
