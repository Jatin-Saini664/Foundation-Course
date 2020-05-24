import java.util.*;

public class amicable {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 10000;
        int a=0;
        boolean[] arr = new boolean[n+1];
        for(int i=2;i<=n;i++){
            if(arr[i]==false){
                int sum=0;
                for(int j=2;j*j<=i;j++){
                    if(i%j==0){
                        if(j==(i/j)){
                            sum+=j;
                        }else{
                            sum+=(i/j);sum+=j;
                        }
                    }
                }
                sum+=1;
                int sum1=0; 
                for(int j=2;j*j<=sum;j++){
                    if(sum%j==0){
                        if(j==(sum/j)){
                            sum1+=j;
                        }else{
                            sum1+=(sum/j);sum1+=j;
                        }
                    }
                }
                sum1+=1;
                if(sum1==i&&sum1!=sum){
                    arr[i]=true;arr[sum1]=true;
                }
            }
        }
        for(int i=0;i<=n;i++){
            if(arr[i]==true){
                a+=i;
                System.out.print(i+" ");
            }
        }
        System.out.println(a);
    }
}