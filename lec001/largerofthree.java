import java.util.*;
class largerofthree{
    public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a,b,c;
    System.out.println("Enter First Number");
    a=scn.nextInt();
    System.out.println("Enter Second Number");
    b=scn.nextInt();
    System.out.println("Enter Third Number");
    c=scn.nextInt();
    if(a>b && a>c){
        System.out.println("larger is =" +a);
    }else if(b>a && b>c){
        System.out.println("larger is =" +b);
    }else{
        System.out.println("larger is =" +c);
    }
  }
}