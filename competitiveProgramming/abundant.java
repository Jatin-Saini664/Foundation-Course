import java.math.BigInteger;
import java.util.*;

public class abundant {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= 28123;
        BigInteger sum = BigInteger.ONE;
        boolean[] arr = new boolean[n+1];
        for(int i=2;i<=n;i++){
            int sum1=0;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    if(j==(i/j))
                        sum1+=j;
                    else{
                        sum1+=j;sum1+=(i/j);
                    }
                }
            }
            sum1+=1;
            if(i<sum1){
                arr[i]=true;
            }
        }
        int count=0;
        for(int i=2;i<=n;i++){
            count=0;
            for(int j=12;j<=i/2;j++){
                if(arr[j]==true||arr[i-j]==true){
                    count=1;
                    break;
                }
            }
            if(count==0)
                sum=sum.add(BigInteger.valueOf(i));
        }
        // System.out.println(arr[16]);
        System.out.println(sum);
    }
}