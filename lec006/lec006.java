import java.util.*;
class lec006{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt(); 
        }
    }
    public static void maxrot(int[] arr, int si, int ei){
        // int n = arr.length-1;
        // int temp=0;
        // int temp1=0;
        // for(int i=1;i<=r;i++){
        //     temp=arr[n];
        //     for(int j=arr.length-1;j>=0;j--){
        //         temp1=arr[j];
        //         arr[j]=arr[j-1];
        //         arr[j-1]=temp1;
        //     }
        //     arr[0]=temp;
        // }
            for(;si<ei;si++){
                int temp=arr[si];
                arr[si]=arr[ei];
                arr[ei]=temp;
                si++;ei--;
            }
    }
    public static void main(String[] args){
        // int size=scn.nextInt();
        // int[] arr = new int[size];
        // input(arr);
        // int n= arr.length-1;
        // for(int i=0;i<=arr.length/2;i++){
        //     int temp = arr[i];
        //     arr[i]=arr[n];
        //     arr[n]=temp;
        //     n--;
        // }
        // for(int j=0;j<arr.length;j++){
        //     System.out.print(arr[j]);
        // }
        int size=scn.nextInt();
        int[] arr = new int[size];
        int r= scn.nextInt();
        input(arr);
        if(r<0)
            r+=arr.length;
        r%=arr.length;
        maxrot(arr, arr.length-r,arr.length-1);
        maxrot(arr, 0 , arr.length-r-1);
        maxrot(arr, 0, arr.length-1);
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }
}