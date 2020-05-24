import java.util.*;
class test{
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int size;
        size=scn.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int sum1=0;
        int sum=0;
        int sum2=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum<0){
                sum=0;
                sum1=0;
            }
            else
                sum1=sum;
            if(sum1>sum2)
                sum2=sum1;
        }
        System.out.print(sum2);
    }
}