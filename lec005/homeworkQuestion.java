import java.util.Scanner;
class homeworkQuestion{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    } 
    public static void subtraction(int[] arr1, int[] arr2){
        int size = arr1.length;
        if(size<arr2.length)
            size=arr2.length;
        int[] res = new int[size];
        int i = arr1.length-1;
        int j = arr2.length-1;
        int k = res.length-1;
        int borrow=0;
        while(i>=0&&j>=0&&k>=0){
            res[k]=arr1[i]-arr2[j]-borrow;
            if(res[k]<0&&k!=0){
                res[k]+=10;
                borrow=1;
            }
            else if(res[k]<0&&k==0)
                res[k]+=10;
            else
                borrow=0;
            i--;j--;k--;
        }
        while(i>=0){
            res[k]=arr1[i]-borrow;
            borrow=0;
            k--;i--;
        }
        while(j>=0){
            res[k]=arr2[j]-borrow;
            borrow=0;
            k--;j--;
        }
        for(int c=0;c<res.length;c++){
            System.out.print(res[c]+" ");
        }
    }
    public static void main(String[] args){
        int size = scn.nextInt();
        int size1 = scn.nextInt();
        int[] arr1 = new int[size];
        int[] arr2 = new int[size1];
        input(arr1);
        input(arr2);
        subtraction(arr1,arr2);
    }
}