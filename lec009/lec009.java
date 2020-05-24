import java.util.*;

class lec009{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    public static void wavedisplay(int[][] arr){
    //     int j=0;
    //     int c=0;
    //     for(int i=0;i<=arr.length;){
    //         if(i==arr.length){
    //             j++;c++;i--;
    //         }+
    //         if(i==-1){
    //         j++;c++;i++;
    //     }
    //         if(i==arr.length&&j==arr[0].length)
    //             break;
    //         System.out.println(arr[i][j]);
    //         if(c%2!=0)
    //             i--;
    //         else
    //             i++;
    //     }
        int c=0;
        for(int j=0;j<arr[0].length;j++){
            if(c%2==0){
                for(int i=0;i<arr.length;i++){
                    System.out.print(arr[i][j]+" ");
                }
            }else{
                for(int i=arr.length-1;i>=0;i--){
                    System.out.print(arr[i][j]+" ");
                }
            }
            c++;
        }
    } 
    public static void spiral(int[][] arr){
        // int a=arr[0].length-1;
        // int b=arr.length-1;
        // int c=0;
        // int j=0;
        // for(int i=0;i<arr.length;i++){
        //     if(i<b&&j<a)
        //         System.out.println(arr[i][j]);
        //     if(i==b){
        //         for(int k=0;k<a;k++)
        //             System.out.print(arr[i][k]);
        //     }
        //     if(j==a){
        //         for(int k=b;k>=0;k--)
        //             System.out.print(arr[i][k]);
        //     }
        // }
        int rmin=0;
        int rmax=arr.length-1;
        int cmin=0;
        int cmax=arr[0].length-1;
        int count=0;
        while(count<arr.length*arr[0].length&&cmax>=cmin&&rmax>=rmin){
            for(int i=rmin;i<=rmax;i++){
                System.out.print(arr[i][cmin]+" ");
                count++;
            }
            cmin++;
            for(int i=cmin;i<=cmax;i++){
                System.out.print(arr[rmax][i]+" ");
                count++;
            }
            rmax--;
            for(int i=rmax;i>=rmin&&rmax!=cmax;i--){
                System.out.print(arr[i][cmax]+" ");
                count++;
            }
            cmax--;
            for(int i=cmax;i>=cmin;i--){
                System.out.print(arr[rmin][i]+" ");
                count++;
            }
            rmin++;
        }
    }
    public static void maze(int[][] arr){
        // int i=1;
        // int j=1;
        // int c=0;
        // int r=0;
        // while(true){
        //     if(arr[i][j]!=1){
        //         if(c==1)
        //             j++;
        //         else if(c==2)
        //             i++;
        //         else if(c==3)
        //             j--;
        //         else if(c==4)
        //             i--;
        //     }
        //     else if(arr[i][j]==1){
        //         if(c<4)
        //             c++;
        //         else if(c>=4)
        //             c=1;
        //     }
        //     if((i==arr.length&&arr[i][j]!=1)||(j==arr[0].length&&arr[i][j]!=1)){
        //         System.out.print(i+" "+j);
        //         break;
        //     }
        // }
        int r=0;
        int c=0;
        int dir=0;
        while(true){
            dir+=arr[r][c];
            dir%=4;
            if(dir==0)
                c++;
            else if(dir==1)
                r++;
            else if(dir==2)
                c--;
            else 
                r--;
            if(r<0||c<0||r==arr.length||c==arr[0].length)
                break;
        }
        if(r<0)r++;
        if(c<0)c++;
        if(c==arr[0].length)c--;
        if(r==arr.length)r--;
        System.out.print(r+" "+c);
    }

    public static void main(String[] args){
        int size=scn.nextInt();
        int size1=scn.nextInt();
        int[][] arr = new int[size][size1];
        input(arr);
        //wavedisplay(arr);
        spiral(arr);
        //maze(arr);
    } 
}