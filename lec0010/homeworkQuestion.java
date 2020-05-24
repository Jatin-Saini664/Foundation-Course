import java.util.*;
class homeworkQuestion{
    static Scanner scn = new Scanner(System.in); 
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void pair(int[] arr){
        int i=0;
        int j=arr.length-1;
        int r=0;
        while(i<=j){
            r=150-arr[j];
            if(r<0){
                j--;
                continue;
            }
            if(r>arr[i])
                i++;
            else if(r<arr[i])
                j--;
            else{
                System.out.println(arr[i]+" "+arr[j]);
                i++;j--;
            }
        }
    }
    public static void main(String[] args){
        int size = scn.nextInt();
        int[] arr = new int[size];
        input(arr);
        pair(arr);
    }
}