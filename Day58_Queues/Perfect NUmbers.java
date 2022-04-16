public class Solution {
    public void enque(Queue<StringBuilder> q){
        StringBuilder topNumber=q.peek();
        for(int i=1;i<=2;i++){
            q.add(new StringBuilder(topNumber+String.valueOf(i)));
        }
    }

    public StringBuilder getPerfectNumber(StringBuilder num){
        StringBuilder perfectNum=new StringBuilder(num+""+num.reverse());
        return perfectNum;
    }
    public String solve(int A) {
        int counter=0;
        Queue<StringBuilder> specialQ=new LinkedList();
        specialQ.add(new StringBuilder("1"));
        specialQ.add(new StringBuilder("2"));
        StringBuilder perfectNum=new StringBuilder("");
        while(counter<A){
            enque(specialQ);
            perfectNum=specialQ.poll();
            counter++;
            //System.out.println(specialQ.size());
        }
        return getPerfectNumber(perfectNum).toString();
    }
}
