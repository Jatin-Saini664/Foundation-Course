import java.util.*;

class newyearchaos{
    public static void minBribes(int[] arr){
        int revcount=0;
        int forcount=0;
        int c=0; 
        int p=0;
        boolean flag = true;
        for(int i=0;i<arr.length;i++){
            p=arr[i];
            if(i==p-1)
                continue;
            else if(i<p-1){
                forcount=(p-1-i);
            }
            else {
                if(p-2>=0&&arr[p-1]>p&&arr[p-2]>p)
                    c=2;
                if(p-2>=0&&arr[p]==p+1&&arr[p-1]==p+2)
                    c=3;
                if(c>i-p+1)
                    revcount+=c;
                else
                    revcount+=i-p+1;
                c=0;
            }
            if(forcount>2){
                flag=false;
                System.out.println("Too chaotic");
                break;
            }
        }
        if(flag)
            System.out.println(revcount);
    } 
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        minBribes(arr);
    }
}