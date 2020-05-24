import java.io.*;
import java.util.*;

public class subsetsOfArray{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int size = scn.nextInt();
    int[] arr = new int[size];
    int[] arr2 = new int[size];
    for(int i=0;i<arr.length;i++){
        arr[i] = scn.nextInt();
        arr2[i]=arr[i];
    }
    int pow=1;
    for(int i=0;i<arr.length;i++){
        pow*=2;
    }
    int count=0;
    while(count<pow){
        int cc=count;
        int length=arr.length-1;
        while(cc!=0){
            int rem=cc%2;
            cc/=2;
            if(rem==1)
                arr2[length]=arr[length]*10;
            else
                arr2[length]=arr[length];
            length--;
        }
        for(int i=0;i<arr2.length;i++){
            if(arr[i]!=arr2[i]){
                System.out.print(arr[i]+"\t");
                arr2[i]=arr[i];
            }
            else
                System.out.print("-"+"\t");
        }
        count++;
        System.out.println();
    }
 }
}