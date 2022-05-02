public class Solution {
    public int getDigitsCount(int A){
        int result=0;
        while(A>0){
            A/=10;
            result++;
        }

        return result;
    }
    public int[] getDigits(int A,int len){
        int[] digits=new int[len];
        for(int i=0;i<len;i++){
            digits[i]=A%10;
            A/=10;
        }
        return digits;
    }
    public void reverse(int[] A){
        int start=0;
        int end=A.length-1;
        while(start<end){
            int temp=A[start];
            A[start]=A[end];
            A[end]=temp;
            start++;
            end--;
        }
    }
    public int colorful(int A) {
        int len=getDigitsCount(A);
        HashSet<Integer> products=new HashSet();
        int[] digits=getDigits(A,len);
        reverse(digits);
        for(int i=1;i<=len;i++){
            for(int j=0;(j+i)<=len;j+=i){
                int product=1;
                for(int k=j;(k<(i+j))&&(k<len);k++){
                    product*=digits[k];
                    
                }
                //System.out.println(product);
               if(products.contains(product))
                    return 0;
                else
                    products.add(product);
            }

        }

        return 1;
    }
}
