public class Solution {
    public boolean isEligibleDiagonal(int x1,int y1,int x2,int y2){
        if(x1==x2 || y1==y2){
            return false;
        }

        return true;
    }


    public int solve(int[] A, int[] B) {
        int len=A.length;
        long result=0l;

        HashSet<ArrayList<Integer>> allCordinates=new HashSet<ArrayList<Integer>>();

        for(int i=0;i<len;i++){
            ArrayList<Integer> singlePoint=new ArrayList();
            singlePoint.add(A[i]);
            singlePoint.add(B[i]);
            allCordinates.add(singlePoint);
        }

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(isEligibleDiagonal(A[i],B[i],A[j],B[j])){

                    ArrayList<Integer> thirdCordinate=new ArrayList();
                    ArrayList<Integer> fourthCordinate=new ArrayList();
                    thirdCordinate.add(A[i]);
                    thirdCordinate.add(B[j]);
                    fourthCordinate.add(A[j]);
                    fourthCordinate.add(B[i]);

                    if(allCordinates.contains(thirdCordinate) && allCordinates.contains(fourthCordinate))
                        result++;
                }
            }
        }

        return (int)result/2;

    }
}
