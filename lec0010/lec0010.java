import java.util.*;


class lec0010{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    public static void pattern(int[][] arr){
        int b=arr[0].length-1;
        for(int i=0;i<arr.length;i++){
            b=arr[0].length-1;
            for(int j=0;j<arr[0].length/2;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[i][b];
                arr[i][b]=temp;
                b--;
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i!=j)
                    continue;
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void sumSubarray(int[] arr){
        int cmax=0,ce=0,sum=10,cs=0;
        while(ce<arr.length){
            if(cmax<sum){
                cmax+=arr[ce];
                ce++;
            }
            else if(cmax>sum){
                cmax-=arr[cs];
                cs++;
            }
            else
                break;
            // if(omax<cmax){
            //     omax=cmax;
            //     os=cs;
            //     oe=ce;
            // }
        }
        System.out.println(cs+" "+(ce-1));
    }
    public static void main(String[] args){
        int size = scn.nextInt();
        //int size1=scn.nextInt();
        //int[][] arr = new int[size][size1];
        //input(arr);
        //pattern(arr);
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        sumSubarray(arr);
    }
}