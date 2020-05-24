import java.util.*;

public class lec0023 {
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int[] arr,int lo,int hi){
        int i=lo;
        int j=lo;
        int pivot=arr[hi];
        while(j<=hi){
            if(arr[j]<=pivot){
                swap(arr,i,j);
                i++;
            }
            j++;
        }
        return i-1;
    }
    public static void qsort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int n=partition(arr,lo,hi);
        qsort(arr,0,n-1);
        qsort(arr,n+1,hi);
        
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        qsort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}