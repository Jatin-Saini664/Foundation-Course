import java.util.*;

public class goldbachCon {
    public static boolean[] seive(int n) {
        boolean[] arr = new boolean[n+1];
        for(int i=0;i<n;i++){
            arr[i]=true;
        }
        for(int p=2;p*p<n;p++){
            if(arr[p]==true){
                for(int i=p*p;i<n;i+=p){
                    arr[i]=false;
                }
            }
        }
        return arr;
    }
    public static int[] square(int n) {
        int[] arr = new int[n+1];
        int j=1;
        for(int i=0;i<n;i++){
            if(2*j*j<=n)
                arr[i]=2*j*j;
            else
                break;
            j+=1;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 10000;
        boolean[] arr = seive(n);
        int[] a = square(n);
        int count=0;
        // for(int i=2;i<n;i++){
        //     count=0;
        //     if(arr[i]==false&&i%2!=0){
        //         for(int j=0;a[j]<i;j++){
        //             if(arr[i-a[j]]==true){
        //                 count=1;
        //                 break;
        //             }
        //         }
        //         if(count==0){
        //             System.out.println(i);
        //             break;
        //         }
        //     }
        // }
        for(int i=900;i<1600;i++){
            if(arr[i])
            System.out.print(i+" ");
        }
        System.out.println(arr[1601]);
    }
}