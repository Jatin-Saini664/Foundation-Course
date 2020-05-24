import java.util.*;
class lec008{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    public static void fillArray(int[][] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=count;
                count++;
            }
        }
    }
    public static void display(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void multiplication(int[][] arr,int[][] arr1){
        int[][] c=new int[arr.length][arr1[0].length];
        if(arr[0].length==arr1.length){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr1[0].length;i++){
                    for(int k=0;k<arr[0].length;k++){
                        c[i][j]+=arr[i][k]*arr1[k][j];
                    }
                }
            }
            for(int i=0;i<c.length;i++){
                for(int j=0;j<c[0].length;j++){
                    System.out.print(c[i][j]+" ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("multiplication of given matrix cannot be done");
    }
    public static void main(String[] args){
        int row=scn.nextInt();
        int col=scn.nextInt();
        int[][] arr = new int[row][col];
        //fillArray(arr);
        //display(arr);
        int row1=scn.nextInt();
        int col1=scn.nextInt();
        int[][] arr1=new int[row1][col1];
        input(arr);
        input(arr1);
        multiplication(arr,arr1);
    }
}