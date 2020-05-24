import java.util.Scanner;
import java.lang.Math;
class specialQuestion{
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int n;
        int r=0;
        int r1=0;
        int r2=0;
        int res=0;
        n=scn.nextInt();
        while(n!=0){
            r=(n%2);
            n/=2;
            if(r==1)
                r1++;
            else
                r2++;
        }
        while(r1!=0){
            res+=Math.pow(2,r2);
            r2++;r1--;
        }
        System.out.println(res);
    }
}