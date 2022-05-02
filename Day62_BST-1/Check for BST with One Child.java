public class Solution {
    public String solve(ArrayList<Integer> A) {
        int maxLimit=Integer.MAX_VALUE;
        int minLimit=Integer.MIN_VALUE;
        int length=A.size();
        if(length<1)
            return "YES";
        int prev=A.get(0);

        for(int i=1;i<length;i++){
            int currElement=A.get(i);
            //System.out.println("min:"+ minLimit);
            if(currElement<minLimit || currElement>maxLimit)
                return "NO";            
            if(currElement>prev)
                minLimit=prev;
            else if(currElement<prev)
                maxLimit=prev;
            
            prev=currElement;
        }
        return "YES";
    }
}
