import java.util.*;

class lec0020{
    static Scanner scn = new Scanner(System.in);
    public static int staircase(int[] arr,int i,int target){
        if(i==arr.length-1){
            return 0;
        }
        int count=0,min=0;
        for(int j=1;j<=arr[i];j++){
            if(i+j<=arr.length-1){
                count=staircase(arr,i+j,target)+1;
            }
            if(count<target)
                target=count;min=count;
        }
        return min;
    }
    public static void main(String args[]){
        int n=scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.println(staircase(arr,0,Integer.MAX_VALUE));
    }
} 