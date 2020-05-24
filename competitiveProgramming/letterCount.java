import java.util.*;

public class letterCount {
    public static int[] letter(int n) {
        int[] arr = new int[n+1];
        arr[0]=3;
        arr[1]=3;arr[2]=3;arr[3]=5;arr[4]=arr[5]=4;arr[6]=3;arr[7]=arr[8]=5;arr[9]=4;arr[10]=3;
        arr[11]=arr[12]=6;arr[13]=arr[14]=8;arr[15]=arr[16]=7;arr[17]=9;arr[18]=arr[19]=8;arr[20]=6;
        arr[30]=6;arr[40]=arr[50]=arr[60]=5;arr[70]=7;arr[80]=arr[90]=6;arr[100]=10;arr[1000]=11;
        int c=10,s=0;arr[200]=10;arr[300]=12;arr[400]=arr[500]=11;arr[600]=10;arr[700]=arr[800]=12;arr[900]=11;
        for(int i=21;i<=n;i++){
            s=i;
            if(arr[i]==0){
                int c1=i%c;
                i=i/c;
                i*=c;
                if(s<100)
                    arr[s]=arr[i]+arr[c1];
                else
                    arr[s]=arr[i]+arr[c1]+arr[0];
            }
            i=s;
            if(i==99)
                c=100;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=1000;
        int[] arr = letter(n);
        int sum=0;
        for(int i=1;i<arr.length;i++){
            sum+=arr[i];
        } 
        System.out.println(arr[999]);
        System.out.println(sum);
    }
}