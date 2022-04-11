public class Solution {

    public int solve(String A) {
        int length=A.length();
        int[] arrayLPS=new int[length];
        arrayLPS[0]=0;
        for(int i=1;i<length;i++){
            int x=arrayLPS[i-1];
            while(A.charAt(x)!=A.charAt(i)){
                if(x==0){
                    x=-1;
                    break;
                }
                x=arrayLPS[x-1];
            }
            arrayLPS[i]=x+1;
        }
        StringBuffer searchPattern=new StringBuffer(A);
        searchPattern.append('|');
        searchPattern.append(new StringBuffer(A).reverse());
        int prevLPS=0;
        int currLPS=0;
        for(int i=length+1;i<searchPattern.length();i++){
            int x=prevLPS;
            while(searchPattern.charAt(x)!=searchPattern.charAt(i)){
                if(x==0){
                    x=-1;
                    break;
                }
                x=arrayLPS[x-1];
            }
            currLPS=x+1;
            prevLPS=currLPS;
        }

        return (length-currLPS);

    }
}
