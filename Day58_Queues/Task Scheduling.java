public class Solution {
    public int solve(int[] A, int[] B) {
        Queue<Integer> scheduledTasks=new LinkedList();
        int length=A.length;
        for(int i=0;i<length;i++){
            scheduledTasks.offer(A[i]);
        }
        int clockCycles=0;
        int i=0;
        while(scheduledTasks.size()>0){
            if(scheduledTasks.peek()==B[i]){
                scheduledTasks.poll();
                i++;
            }
            else
                scheduledTasks.offer(scheduledTasks.poll());

            clockCycles++;
        }
        return clockCycles;
    }
}
