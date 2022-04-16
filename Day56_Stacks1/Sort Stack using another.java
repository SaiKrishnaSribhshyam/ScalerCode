public class Solution {
    public Stack<Integer> merge(Stack<Integer> part1,Stack<Integer> part2){
        Stack<Integer> mergedStack=new Stack<Integer>();
        while(part1.size()>0 && part2.size()>0){
            if(part1.peek()<part2.peek()){
                mergedStack.push(part1.pop());
            }
            else{
                mergedStack.push(part2.pop());
            }
        }
        if(part2.size()>0)
            part1=part2;
        while(part1.size()>0){
            mergedStack.push(part1.pop());
        }

        return mergedStack;
    }
    public Stack<Integer> mergeSort(Stack<Integer> A){
        if(A.size()==1)
            return A;
        
        int mid=A.size()/2;
        Stack<Integer> upperStack=new Stack();
        while(mid>0){
            upperStack.push(A.pop());
            mid--;
        }
        //System.out.println(A);
        A=mergeSort(A);
        upperStack=mergeSort(upperStack);
        //System.out.println(upperStack);
        Stack<Integer> sortedStack=merge(A,upperStack);
        Stack<Integer> reverse=new Stack<Integer>();
        while(sortedStack.size()>0){
            reverse.push(sortedStack.pop());
        }
        return reverse;
    }
    public int[] solve(int[] A) {
        Stack<Integer> unsortedStack=new Stack();
        for(int e:A){
            unsortedStack.push(e);
        }
        Stack<Integer> sortedStack=mergeSort(unsortedStack);
        int[] sortedArray=new int[A.length];
        for(int i=0;i<A.length;i++){
            sortedArray[i]=sortedStack.pop();
        }
        return sortedArray;
    }
}
