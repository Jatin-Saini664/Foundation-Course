import java.util.*;

public class modArith {
    public static long fact(int n){
        long sum=1;
        for(int i=1;i<=n;i++){
            sum*=i;
        }
        return sum;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int a=scn.nextInt();
        int b=scn.nextInt();
        long sum1=fact(a)%1000000007;
        long sum2=fact(b)%1000000007;
        System.out.println((sum1+sum2)%1000000007);
    }
}