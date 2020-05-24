import java.util.*;

class bubble{
    static Scanner scn = new Scanner(System.in);
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void selectionSort(int[] arr){
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]>arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    }
    public static void sort(int[] arr,int[] arr1){
        int j=0,i=0;
        int[] arr2 = new int[arr.length+arr1.length];
        int b=0;
        for(;i<arr.length||j<arr1.length;){
            if(i<arr.length&&j<arr1.length&&arr[i]<arr1[j]){
                arr2[b]=arr[i];
                if(i<arr.length)
                    i++;
                b++;
            }else if(i<arr.length  && j<arr1.length){
                arr2[b]=arr1[j];
                if(j<arr1.length)
                    j++;
                b++;
            }else if(i<arr.length&&j==arr.length){
                arr2[b]=arr[i];
                i++;
                b++;
            }else if(j<arr1.length&&i==arr.length){
                arr2[b]=arr1[j];
                j++;
                b++;
            }
        }
        for(i=0;i<arr2.length;i++){
            System.out.println(arr2[i]);
        }
    }public static void insertion(int[] arr){
        for(int i=1;i<arr.length-1;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else
                    break;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    public  static void main(String[] args){
        int n=scn.nextInt();
        //int n1=scn.nextInt();
        int[] arr = new int[n];
        //int[] arr1 = new int[n1];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        //bubbleSort(arr);
        //selectionSort(arr);
        insertion(arr);
        // for(int i=0;i<arr1.length;i++){
        //     arr1[i]=scn.nextInt();
        // }
        // sort(arr,arr1);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]+" ");
        // }
    }
}