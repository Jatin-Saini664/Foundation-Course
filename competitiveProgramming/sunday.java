import java.util.*;

public class sunday {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = {1,32,60,91,121,152,182,213,244,274,305,335};
        int[] arr1 = {1,32,61,92,122,153,183,214,245,275,306,336};
        int[] help = {0,28,56,91,119,147,182,210,238,273,301,329};
        int n=6,count=0;
        for(int i=1901;i<=2000;i++){
            if(i%4==0){
                if(n==7) count+=2;
                else{
                    for(int j=0;j<arr1.length;j++){
                        if(arr1[j]==help[j]+n)
                            count++;
                    }
                }
                if(n==1)
                    n=7;
                else
                    n--;
                System.out.print(n+" ");
            }else{
                if(n==7) count+=2;
                else{
                    for(int j=0;j<arr.length;j++){
                        if(arr[j]==help[j]+n)
                            count++;
                    }
                }
                System.out.print(n+" ");
            }
        }
        System.out.println(count);
        int k=1;
        while(k<365){
            k+=7;
        }
        System.out.println(k);
    }
}