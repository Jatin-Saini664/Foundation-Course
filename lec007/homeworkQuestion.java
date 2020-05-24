import java.util.*;
class homeworkQuestion{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = scn .nextInt();
        }
    }
    public static void subarray(int[] arr){
        // int sum=0;
        // int sum1=arr[0];
        // int sum2=0;
        // int first=0;
        // int last=0;
        // int c=0;
        // for(int i=0;i<arr.length;i++){
        //     sum+=arr[i];
        //     // if(sum<sum2&&sum<=0){
        //     //     first=i+1;
        //     //     last=i+1;
        //     //     sum=arr[i+1];
        //     // }
        //     if(sum<=0){
        //         first=i+1;
        //         last=i+1;
        //         sum=0;
        //     }
        //     if(sum1<sum){
        //         sum1=sum;
        //         last++;
        //     }
        //     else
        //         c++;
        //     if(c>0){
        //         last++;
        //         c--;
        //     }
        //     sum2=sum;
        // } 
        // System.out.println(sum1);
        // System.out.println(first+" "+(last-=2));
        int omax=arr[0],os=0,oe=0,cmax=0,cs=0,ce=0;
        while(ce<arr.length){
            if(cmax>0)
                cmax+=arr[ce];
            else{
                cmax=arr[ce];
                cs=ce;
            }
            if(omax<cmax){
                omax=cmax;
                os=cs;
                oe=ce;
            }
            ce++;
        }
        for(int i=os;i<=oe;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(" "+omax);
    }
    public static void main(String[] args){
        int size=scn.nextInt();
        int[] arr = new int[size];
        input(arr);
        subarray(arr);
    }
}