import java.util.*;
class lec007{
    static Scanner scn=new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++)
            arr[i]=scn.nextInt();
    }
    public static void subsets(int[] arr){
        // int s= arr.length;
        // if(s%2!=0)
        //     s=arr.length-1;
        // int c=1;
        // int c2=1;
        // int a=0;
        // for(int i=0;i<s;i++){
        //     c=c2;
        //     for(int j=0;j<arr.length;j++){
        //         a=0;        //         if(c>0)
        //             System.out.print(arr[j]);
        //         else
        //             System.out.println();
        //         c--;
        //     }
        //     c2++;
        // }
        int pow=1;
        for(int i=0;i<arr.length;i++)
            pow*=2;
        int count = 0;
        while(count<pow){
            int cc=count;
            int length=0;
            while(cc!=0){
                int rem=cc%2;
                cc/=2;
                if(rem==1)
                    System.out.print(arr[length]+" ");
                length++;
            }
            count++;
            System.out.println();
        }
        }

        public static void subarray(int[]arr){
            int max=0;
            for(int i=0;i<arr.length;i++)
                max+=arr[i];
            int first=0;
            int last=arr.length-1;
            for(int i=0;i<arr.length;i++){
                
            }
        }
    public static void main(String[] args){
        int size = scn.nextInt();
        int[] arr = new int[size];
        input(arr);
        subsets(arr);
    }
}