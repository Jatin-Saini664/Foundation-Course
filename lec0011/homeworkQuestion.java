import java.util.*;

class homeworkQuestion{
    static Scanner scn= new Scanner(System.in);
    public static void input(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    public static void diagonal(int[][] arr){
        int i=arr.length-1;
        int j=0;
        int a=i;
        int b=j;
        while(true){
            System.out.print(arr[i][j]+" ");
            i++;
            j++;
            if(i==arr.length||j==arr[0].length){
                if(a>0){
                    a--;
                    i=a;
                    j=0;
                }else if(b<arr[0].length-1){
                    b++;
                    j=b;
                    i=0;
                }else
                    break;
            }
        }
    }
    public static void snakeDiagonal(int[][] arr){
        int i=arr.length-1;
        int j=0;
        int a=1;
        while(true){
            System.out.print(arr[i][j]+" ");
            if(a%2!=0){
                i++;j++;
            }else{
                i--;j--;
            }
            if(i==arr.length||j==arr[0].length){
                if(a%2!=0){
                    if(j<arr[0].length)
                        i=arr.length-1;
                    else{
                        j=arr[0].length-1;
                        i-=2;
                    }
                    a++;
                }else{
                    if(i>0)
                        j=0;
                    else{
                        i=0;
                        j+=2;
                    }
                }
                if(a==arr[0].length*2)
                    break;
            }
        }
    }
    public static void main(String[] args){
        int size=scn.nextInt();
        int size1=scn.nextInt();
        int[][] arr = new int[size][size1];
        input(arr);
        diagonal(arr);
        snakeDiagonal(arr);
    }
}