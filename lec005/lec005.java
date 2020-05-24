import java.util.Scanner;
class lec005{
    static Scanner scn = new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int max(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    public static int min(int[] arr){
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min)
                min=arr[i];
        }
        return min;
    }
    public static int span(int[] arr){
        int max = max(arr);
        int min = min(arr);
        return max-min;
    }
    public static void arrayAddition(int[] arr1, int[] arr2){
        // int result=0;
        // int carry=0;
        // int i=(arr1.length>arr2.length)?arr1.length-1:arr2.length-1;
        // int[] c= new int[i+1];
        // while(arr1.length!=i-1||arr2.length!=i-1||carry!=0){
        //     result=arr1[i]+arr2[i]+carry;
        //     carry=result/10;
        //     result=result%10;
        //     c[i]=result;
        //     i--;
        // }
        // for(i=1;i<c.length;i++){
        //     System.out.print(c[i]);
        // }
        int size = arr1.length;
        if(size<arr2.length){
            size=arr2.length;
        }
        size++;
        int[] res = new int[size];
        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=res.length-1;
        int carry=0;
        while(i>=0&&j>=0&&k>=0){
            int num = arr1[i]+arr2[j]+carry;
            carry=num/10;
            num=num%10;
            res[k]=num;
            i--;j--;k--;
        }
        while(i>=0){
            int num=arr1[i]+carry;
            carry=num/10;
            res[k]=num%10;
            i--;k--;
        }
        while(j>=0){
            int num=arr2[i]+carry;
            carry=num/10;
            res[k]=num%10;
            j--;k--;
        }
        if(carry>0){
            res[k]=carry;
            k--;
        }
        for(int c=0;c<res.length;c++){
            if(c==0&&res[c]==0)
                continue;
            System.out.print(res[c]+" ");
        }
    }
    public static void main(String[] args){
        int size=scn.nextInt();
        int size1=scn.nextInt();
        int[] arr1 = new int[size];
        int[] arr2 = new int[size1];
        input(arr1);
        input(arr2);
        //System.out.println(max(arr));
        //System.out.println(min(arr));
        arrayAddition(arr1,arr2);
        //System.out.println(span(arr));
        //display(arr);
    }
}