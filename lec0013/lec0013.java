import java.util.*;

class lec0013{
    static Scanner scn = new Scanner(System.in);
    public static void p1(int x){
        if(x==0)
            return;
        System.out.println(x);
        p1(x-1);
    }
    public static void p2(int x){
        if(x==0)
            return;
        p2(x-1);
        System.out.println(x);
    }
    public static void p3(int x){
        if(x==0)
        return;
        System.out.println(x);
        p3(x-1);
        if(x>1)
        System.out.println(x);
    }
    public static int factorial(int r){
        if(r!=1)
            return r*factorial(r-1);
        return 0;
    }
    public static void main(String[] args){
        int x=scn.nextInt();
        //p1(x);
        //p2(x);
        //p3(x);
        System.out.println(factorial(x));
    } 
}