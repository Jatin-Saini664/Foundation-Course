import java.util.*;
class lec0014{
    static Scanner scn = new Scanner(System.in);
    public static void hoi(int n, String s, String h, String d){
        if(n==0){
            return;
        }
        hoi(n-1,s,d,h);
        System.out.println("move "+n+"th from "+s+" to "+d);
        hoi(n-1,h,s,d);
    }
    public static int find(int[] arr,int a,int item){
        int post=-1;
        if(a==arr.length)
            return -1;
        post=find(arr,a+1,item);
        if(post==-1){
            //post=find(arr,a+1,item);
            if(arr[a]==item)
                post=a;
            else
                post=-1;
        }
            //post=find(arr,a+1,item);
        return post;
    }
    public static void main(String[] args){
        //hoi(5,"source","helper","destination");
        int a=scn.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<arr.length;i++)
            arr[i]=scn.nextInt();
        int item =scn.nextInt();
        System.out.println((find(arr,0,item)));
    }
}