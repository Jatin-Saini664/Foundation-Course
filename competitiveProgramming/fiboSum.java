import java.util.*;

public class fiboSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a=1,b=2,c=0,i=3;
        // int s=scn.nextInt();
        long sum=2;
        while(c<4000000){
            c=a+b;
            a=b;b=c;
            if(c%2==0)
                sum+=c;
        }
        System.out.println(sum);
    }
}