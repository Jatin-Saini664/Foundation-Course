import java.util.*;

public class sPrime {
    public static void main(String[] args) {
        boolean[] arr = new boolean[2000100];
        for(int i=0;i<arr.length;i++){
            arr[i]=true;
        }
        long  sum=0;
        for(int p=2;p*p<2000000;p++){
            if(arr[p]==true){
                for(int i=p*p;i<2000000;i+=p){
                    arr[i]=false;
                }
            }
        }
        for(int i=2;i<2000000;i++){
            if(arr[i]==true)
                sum+=i;
        }
        System.out.println(sum);
    }
}