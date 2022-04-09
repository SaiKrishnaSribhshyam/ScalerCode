public class Solution {
    public int power(int num,int power,int mod){
        long base=num;
        long result=1l;
        if(power==0)
            return 1;
        while(power>0){
            if(power%2==1)
                result=(result*base)%mod;
            base=(base*base)%mod;
            power/=2;
        }
        if(result<0)
            result=result+mod;
        return (int)result%mod;
    }

    public int hashCode(String str,int mod){
        int hash=0;
        int length=str.length();
        int prime=31;
        if(length<1)
            return hash;
        int j=0;
        for(int i=length-1;i>=0;i--){
            int bit=str.charAt(i);
            hash=(hash+(bit*power(prime,j,mod))%mod)%mod;
            j++;

        }
        if(hash<0)
            hash=hash+mod;

        return hash;
    }
    public int solve(String A, String B) {
        int mod=(int)Math.pow(10,9)+7;
        //System.out.println("power of 4^4:"+power(4,4,mod));
        
        int lenA=A.length();
        int lenB=B.length();
        StringBuffer specimen=new StringBuffer(B+B.substring(0,lenB-1));
        int length=specimen.length();
        int count=0;
        if(lenA>lenB)
            return 0;
        long currHash=hashCode(specimen.substring(0,lenA),mod);
        long lastHash=currHash;
        int hashA=hashCode(A,mod);
        long valPower=power(31,lenA-1,mod);
        if(hashA==currHash)
            count++;
        int j=1;
        //System.out.println(specimen);
        for(int i=lenA;i<length;i++){
            int removeChar=specimen.charAt(j-1);
            currHash=((lastHash-(removeChar*valPower*1L)%mod)*31)%mod;
            currHash=(currHash+specimen.charAt(i))%mod;
            if(currHash<0)
                currHash=currHash+mod;
            if(currHash==hashA)
                count++;
            System.out.println("Hash code of "+specimen.substring(j,j+lenA) +" :"+ currHash +"function:" +hashCode(specimen.substring(j,j+lenA),mod));
            j++;
            lastHash=currHash;
        }
        return count;
    }
}
