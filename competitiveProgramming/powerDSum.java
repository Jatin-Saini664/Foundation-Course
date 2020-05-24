import java.math.BigInteger;
import java.util.*;

public class powerDSum {
    public static BigInteger power(int n) {
        if(n==1){
            BigInteger b = new BigInteger("2");
            return b;
        }
        BigInteger a = power(n/2);
        a=a.multiply(a);
        if(n%2!=0)
            a=a.multiply(BigInteger.valueOf(2));
        return a;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BigInteger ans = power(1000);
        int sum=0;
        while(ans.compareTo(BigInteger.ZERO)>0){
            sum+=ans.mod(BigInteger.valueOf(10)).intValue();
            ans=ans.divide(BigInteger.valueOf(10));
        }
        System.out.println(sum);
    }
}