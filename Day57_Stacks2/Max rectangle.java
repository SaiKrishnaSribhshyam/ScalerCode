public class Solution {
    public int[] populateLeftMin(int[] A){
        int[] leftMin=new int[A.length];
        Stack<Integer> minStack=new Stack();
        int length=A.length;
        for(int i=0;i<length;i++){
            while(minStack.size()>0 && A[minStack.peek()]>=A[i])
                minStack.pop();
            
            if(minStack.size()>0)
                leftMin[i]=minStack.peek();
            else
                leftMin[i]=-1;
            
            minStack.push(i);
        }
        return leftMin;
    }

    public int[] populateRightMin(int[] A){
        int[] rightMin=new int[A.length];
        Stack<Integer> minStack=new Stack();
        for(int i=A.length-1;i>=0;i--){
            while(minStack.size()>0 && A[minStack.peek()]>=A[i])
                minStack.pop();
            if(minStack.size()>0)
                rightMin[i]=minStack.peek();
            else
                rightMin[i]=-1;
            minStack.push(i);
        }
        return rightMin;
    }
    public int maxArea(int[] A){
        int[] leftMin=populateLeftMin(A);
        int[] rightMin=populateRightMin(A);
        int maxArea=0;
        for(int i=0;i<A.length;i++){
            rightMin[i]=(rightMin[i]==-1)?(A.length):rightMin[i];
            int breadth=(rightMin[i]-1)-(leftMin[i]+1)+1;
            maxArea=Math.max(maxArea,breadth*A[i]);
        }
        return maxArea;
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int rows=A.size();
        int length=A.get(0).size();
        int maxArea=0;
        int[] thisRow=new int[length];

        for(int i=0;i<length;i++){
            thisRow[i]=A.get(0).get(i);
            //System.out.print(thisRow[i]);
        }
        maxArea=maxArea(thisRow);
        for(int i=1;i<rows;i++){
            thisRow=new int[length];
            //System.out.println();
            for(int j=0;j<length;j++){
                int k=(A.get(i)).get(j);
                //System.out.print("k:"+k + " " +A.get(i));
               if(k==1){
                   A.get(i).set(j,A.get(i-1).get(j)+1);
                   thisRow[j]=A.get(i).get(j);
               }
               else
                    thisRow[j]=0;
                //System.out.print("k:"+k + " " +thisRow[j]);
            }
            maxArea=Math.max(maxArea,maxArea(thisRow));
        }

        return maxArea;
    }
}
