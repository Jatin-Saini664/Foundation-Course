import java.util.*;

public class triangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[15][15];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        for(int i=13;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(arr[i+1][j]>arr[i+1][j+1])
                    arr[i][j]+=arr[i+1][j];
                else
                    arr[i][j]+=arr[i+1][j+1];
            }
        }
        System.out.println(arr[0][0]);
    }
}