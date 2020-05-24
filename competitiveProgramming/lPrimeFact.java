import java.util.*;

public class lPrimeFact {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int i=3;
        long s=600851475143L;
        while(!(s%2>0)){
            // equivalent to n=n/2;
            s>>=1;
        }
        for(i=3;i*i<=s;i+=2){
            while(s%i==0){
                s=s/i;
            }
        }
        System.out.println(s);
    }
}