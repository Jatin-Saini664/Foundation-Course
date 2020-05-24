import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class chaining {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size=scn.nextInt();
        int size1=scn.nextInt();
        int k=scn.nextInt();
        int[][] arr = new int[size][size1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        int a=0;
        int b=0;
        int cmin=0,cmax=arr[0].length-1,rmin=0,rmax=arr.length-1;
        for(int i=0;i<arr.length/2;i++){
            int c=cmax;
            for(int k1=0;k1<k;k1++){
                a=arr[rmin][cmax];
            for(int j=c;j>=cmin;j--){
                b=arr[rmin][j];
                arr[rmin][j]=a;
                a=b;
            }
            //rmin++;
            c=rmin+1;
            for(int j=c;j<=rmax;j++){
                b=arr[j][cmin];
                arr[j][cmin]=a;
                a=b;
            }//cmin++;
            c=cmin+1;
            for(int j=c;j<=cmax;j++){
                b=arr[rmax][j];
                arr[rmax][j]=a;
                a=b;
            }//rmax--;
            c=rmax-1;
            for(int j=c;j>=rmin;j--){
                b=arr[j][cmax];
                arr[j][cmax]=a;
                a=b;
            }//cmax--;
            c=cmax-1;
            }
            rmin++;
            cmin++;
            cmax--;
            rmax--;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}