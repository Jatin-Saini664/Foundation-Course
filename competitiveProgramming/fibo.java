import java.math.BigInteger;
import java.util.*;

/*Fibonacci terms converge to (n)*Phi=(n+1), where Phi is the
 Golden Ratio (1+sqrt5)/2.
I reasoned that there is an nth term that is smaller than 10^999
 with the corresponding nth+1 term bigger than 10^999.
So, using the binary splitting method for searching, I used
 the MS calculator and found Phi^4780<10^999 and Phi^4781>10^999.
Since the two initial terms of the series have the same value
 by definition, you have to add one to the exponents found.*/
public class fibo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BigInteger s = new BigInteger("1");
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");
        for(int i=1;i<1000;i++){
            s=s.multiply(BigInteger.valueOf(10));
        }
        int i=2;
        while(c.compareTo(s)<0){
            c=a.add(b);
            a=b;
            b=c;
            i++;
        }
        System.out.println(i);
    }
}