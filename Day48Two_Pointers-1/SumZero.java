public class Solution {
    public void findTriplets(ArrayList<Integer> A,int index,ArrayList<ArrayList<Integer>> triplets){
        long sum=A.get(index)*-1;
        int start=index+1;
        int end=A.size()-1;
        

        while(start<end){
            long currSum=A.get(start)+A.get(end);
            if(currSum>sum)
                end--;
            else if(currSum<sum)
                start++;
            else{
                ArrayList<Integer> triplet=new ArrayList<Integer>();
                triplet.add(A.get(index));
                triplet.add(A.get(start));
                triplet.add(A.get(end));
                triplets.add(triplet);
                start++;
                end--;
                while(start<end && (A.get(start)==A.get(start-1)) && (A.get(end)==A.get(end+1))){
                    start++;
                    end--;
                }
            }
        }
    }
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        int len=A.size();
        ArrayList<ArrayList<Integer>> triplets=new ArrayList();
        if(len<3)
            return triplets;
        
        Collections.sort(A);
        findTriplets(A,0,triplets);
        for(int i=1;i<len;i++){
            //System.out.println((A.get(i-1)+":"+A.get(i)) + (A.get(i-1)*-1!=A.get(i)*-1) );
            if(A.get(i-1)*-1!=A.get(i)*-1)
                findTriplets(A,i,triplets);
        }
        return triplets;
    }
}
