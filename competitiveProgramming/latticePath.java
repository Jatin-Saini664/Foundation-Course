import java.util.*;

public class latticePath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long arr[][] = new long[21][21];
        arr[20][20] = 1;
        for(int i=20;i>=0;i--){
            for(int j=20;j>=0;j--){
                if(i==20&&j==20){
                    continue;
                }
                else{
                    if(i+1<21)
                        arr[i][j]+=arr[i+1][j];
                    if(j+1<21)
                        arr[i][j]+=arr[i][j+1];
                    // if(i+1<4&&j+1<4)
                    //     arr[i][j]+=arr[i+1][j+1];
                }
            }
        }
        System.out.println(arr[0][0]);
    }
}