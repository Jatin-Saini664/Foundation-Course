import java.util.*;

public class lec022 {
    public static int[] merge(int[] arr, int low, int high) {
        if (low == high) {
            int[] arr1 = new int[1];
            arr1[0] = arr[low];
            return arr1;
        }
        int mid = (low + high) / 2;
        int[] left = merge(arr, low, mid);
        int[] right = merge(arr, mid + 1, high);
        int j = 0, i = 0;
        int[] arr4 = new int[left.length + right.length];
        int b = 0;
        for (; i < left.length || j < right.length;) {
            if (i < left.length && j < right.length && left[i] < right[j]) {
                arr4[b] = left[i];
                if (i < left.length)
                    i++;
                b++;
            } else if (i < left.length && j < right.length) {
                arr4[b] = right[j];
                if (j < right.length)
                    j++;
                b++;
            } else if (i < left.length && j == right.length) {
                arr4[b] = left[i];
                i++;
                b++;
            } else if (j < right.length && i == left.length) {
                arr4[b] = right[j];
                j++;
                b++;
            }
        }
        return arr4;
    }

    public static void seg(int[] arr) {
        int a = 0;
        int b = arr.length - 1;
        while (a < b) {
            if (arr[a] == 0)
                a++;
            if (arr[b] == 1)
                b--;
            if (a < b && arr[a] == 1 && arr[b] == 0) {
                int temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
                a++;
                b--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void seg1(int[] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
            j++;
        }
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 

    public static void seg2(int[] arr) {
        int i = 0, j = 0, k = 0;
        while (k < arr.length) {
            if (arr[k] == 0) {
                //2's ko karege shift
                swap(arr,j,k);
                //1's ko karege shift
                swap(arr,j,i);
                i++;j++;
            } else if (arr[k] == 1) {
                swap(arr,j,k);
                j++;
            }
            k++;
        }
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void val(int[] arr){
        int i=0;
        int j=0;
        int val=arr[arr.length-1];
        while(j<arr.length){
            if(arr[j]<=val){
                swap(arr,i,j);
                i++;
            }
            j++;
        }
        System.out.println(i-1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        // int[] ans = merge(arr,0,arr.length-1);
        // for(int i=0;i<ans.length;i++){
        // System.out.print(ans[i]+" ");
        // }
        //seg2(arr);
        val(arr);
    }
}