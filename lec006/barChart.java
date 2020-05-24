import java.io.*;
import java.util.*;

public class barChart{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n;
    n=scn.nextInt();
    int[] arr = new int[n];
    int max=0;
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
        if(arr[i]>max)
            max=arr[i];
    }
    for(int i=0;i<max;i++){
        for(int j=0;j<n;j++){
            if(arr[j]>=max-i){
                System.out.print('*');
                System.out.print('\t');
            }
            else
                System.out.print('\t');
        }
        System.out.println();
    }
    }
}