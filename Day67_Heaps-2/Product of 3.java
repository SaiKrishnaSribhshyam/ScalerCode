public class Solution {
    public int size;
    public int getMax(int[] A,int maxnum){
        if(maxnum==2)
            return Math.max(A[1],A[2]);
        if(maxnum==3)
            return Math.min(A[1],A[2]);
        
        return A[0];
    }
    public void insert(int[] A,int num){
        size++;
        A[size]=num;
        int i=size;
        int p=(i-1)/2;
        while(p>=0 && A[p]<A[i]){
            int temp=A[i];
            A[i]=A[p];
            A[p]=temp;
            i=p;
            p=(i-1)/2;
        }
    }
    public int deleteMax(int[] A){
        int max=A[0];
        A[0]=A[size];
        size--;
        int i=0;
        while(i<=size){
            int l=(2*i+1);
            int r=(2*i+2);
            int maxIndex=i;
            if(l<=size && A[l]>A[maxIndex]){
                maxIndex=l;
            }
            if(r<=size && A[r]>A[maxIndex]){
                maxIndex=r;
            }
            if(maxIndex==i)
                break;
            int temp=A[maxIndex];
            A[maxIndex]=A[i];
            A[i]=temp;
            i=maxIndex;
        }
        return max;
    }
    public int[] solve(int[] A) {
        int[] maxHeap=new int[A.length];
        size=-1;
        int[] result=new int[A.length];
        if(A.length<3)
            return new int[0];
        
        insert(maxHeap,A[0]);
        insert(maxHeap,A[1]);
        result[0]=-1;
        result[1]=-1;
        for(int i=2;i<A.length;i++){
            insert(maxHeap,A[i]);
            int max1=deleteMax(maxHeap);
            int max2=deleteMax(maxHeap);
            int max3=deleteMax(maxHeap);
            result[i]=max1*max2*max3;
            insert(maxHeap,max1);
            insert(maxHeap,max2);
            insert(maxHeap,max3);
        }
        return result;
    }
}
