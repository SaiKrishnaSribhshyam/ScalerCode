public class Solution {
    public int size;
    public void insert(int[] A,int num){
        size++;
        if(size>=A.length)
            return;
        A[size]=num;
        int i=size;
        int p=(size-1)/2;
        while(A[p]>A[i]){
            int temp=A[p];
            A[p]=A[i];
            A[i]=temp;
            i=p;
            p=(i-1)/2;
        }
    }
    public int deleteMin(int[] A){
        int min=A[0];
        A[0]=A[size];
        size--;
        int i=0;
        while(i<=size){
            int l=(2*i+1);
            int r=(2*i+2);
            int minIndex=i;
            if(l<=size && A[l]<A[minIndex]){
                minIndex=l;
            }
            if(r<=size && A[r]<A[minIndex]){
                minIndex=r;
            }

            if(minIndex==i)
                break;
            
            int temp=A[minIndex];
            A[minIndex]=A[i];
            A[i]=temp;
            i=minIndex;
        }
        return min;
    }
    public int solve(int[] A) {
        int length=A.length;
        if(length==0)
            return 0;
        size=length-1;
        Arrays.sort(A);
        long totalcost=0l;
        //for(int i=0;i<=size;i++)
            //System.out.print(A[i]+" ");
        while(size>0){
            int min1=deleteMin(A);
            //System.out.println(A);
            //for(int i=0;i<=size;i++)
                //System.out.print(A[i]+" ");            
            int min2=deleteMin(A);
            insert(A,min1+min2);
            totalcost+=(min1+min2);
            //System.out.println("");
        }
        return (int)(totalcost);
    }
}
