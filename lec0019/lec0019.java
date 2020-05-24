import java.util.*;

class lec0019{
    static Scanner scn = new Scanner(System.in);
    public static void lexico(int a,int b){
        if(a>b){
            return;
        }
        int d=0;
        int e=0;
        System.out.print(a+" ");
        for(int i=0;i<=9;i++){
            int c=a*10+i;
            if(c<=b)
                lexico(c,b);
            else{
                if(a%10==a)
                    e=c;
                break;
            }
            if(i==9&&a/10==0)
                d=c;
        }
        if(d%10==9&&a%10<9)
            lexico(a+1,b);
        else if(e!=0&&a%10<9){
            lexico(a+1,b);
        }
    } 
    public static void main(String[] args){
        lexico(1,100);
    }
}