import java.util.*;
import java.math.*;

public class fact{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BigInteger a = new BigInteger("1");
        int n = 100;
        for(int i=2;i<=n;i++){
            a=a.multiply(BigInteger.valueOf(i));
        }
        int sum=0;
        System.out.println(a);
        while(!a.equals(BigInteger.ZERO)){
            int s = a.mod(BigInteger.valueOf(10)).intValue();
            a=a.divide(BigInteger.valueOf(10));
            sum+=s;
        }
        System.out.println(sum);
    }
}