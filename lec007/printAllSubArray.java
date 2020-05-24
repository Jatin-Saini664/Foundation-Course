import java.io.*;
import java.util.*;

public class printAllSubArray{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int size= scn.nextInt();
    int[] arr = new int[size];
    for(int i=0;i<arr.length;i++){
        arr[i] = scn.nextInt();
    }
    int p=0;
    int end=0;
    for(int i=0;i<arr.length;i++){
        for(int j=p;j<=end;j++){
            System.out.print(arr[j]+"\t");
        }
        end++;
        System.out.println();
        if(i==arr.length-1){
            i=p;
            p++;
            end=p;
        }
    }
 }
}