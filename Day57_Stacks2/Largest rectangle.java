public class Solution {
    public int[] populateLeftMins(int[] A){
        Stack<Integer> currMins=new Stack();
        int length=A.length;
        int[] leftNearestMin=new int[length];

        for(int i=0;i<length;i++){
            while(currMins.size()>0 && A[currMins.peek()]>=A[i])
                currMins.pop();
            
            if(currMins.size()>0)
                leftNearestMin[i]=currMins.peek();
            else
                leftNearestMin[i]=-1;
            
            currMins.push(i);

        }
        return leftNearestMin;
    }
    public int[] populateRightMins(int[] A){
        Stack<Integer> currMins=new Stack();
        int length=A.length;
        int[] rightNearestMin=new int[length];
        for(int i=length-1;i>=0;i--){
            while(currMins.size()>0 && A[currMins.peek()]>=A[i])
                currMins.pop();
            
            if(currMins.size()>0)
                rightNearestMin[i]=currMins.peek();
            else
                rightNearestMin[i]=-1;
            currMins.push(i);
        }
        return rightNearestMin;
    }
    public int largestRectangleArea(int[] A) {
        int length=A.length;
        int[] leftNearestMin;
        leftNearestMin=populateLeftMins(A);
        int[] rightNearestMin=populateRightMins(A);

        int maxArea=-1;
        for(int i=0;i<length;i++){
            int areawithThisHeight;
            int breadth;
            if(leftNearestMin[i]==-1 && rightNearestMin[i]==-1)
                breadth=length;
            else if(leftNearestMin[i]==-1)
                breadth=rightNearestMin[i];
            else if(rightNearestMin[i]==-1)
                breadth=(length-leftNearestMin[i]-1);
            else
                breadth=(rightNearestMin[i]-leftNearestMin[i]-1);
            
            areawithThisHeight=breadth*A[i];
            
            maxArea=Math.max(maxArea,areawithThisHeight);
        }
        return maxArea;
    }
}
