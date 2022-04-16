public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Stack<Integer> reverseElements=new Stack();
        for(int i=0;i<B;i++)
            reverseElements.push(A.get(i));
        
        ArrayList<Integer> orderedQ=new ArrayList();
        for(int i=0;i<B;i++)
            orderedQ.add(reverseElements.pop());
        
        for(int i=B;i<A.size();i++)
            orderedQ.add(A.get(i));
        
        return orderedQ;
    }
}
