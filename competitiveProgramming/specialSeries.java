import java.util.*;

public class specialSeries {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n=0;
        int count=1;
        int max=0;
        for(long i=10000;i<1000000;i++){
            count=1;
            long n1=i;
            while(i!=1){
                if(i%2==0)
                    i/=2;
                else
                    i=3*i+1;
                count++;
            }
            if(count>max){
                max=count;
                n=n1;
            }
            i=n1;
        }
        System.out.println(max+" "+n);
    }
}

/*7659803
235*/