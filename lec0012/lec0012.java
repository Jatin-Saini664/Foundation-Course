import java.util.*;
//import java.String;

class lec0012{
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        String str="abcd";
        //int a=0;
        // for(int i=3;i>=0;i--){
        //     for(int j=0;j<=i;j++){
        //         System.out.print(str.substring(j,a)+" ");
        //         a++;
        //     }
        //     System.out.print(str.substring(i)+" ");
        //     a-=(i);
        //     System.out.println();
        // }
        String str1 = "aBcD";
        String str2="";
        for(int i=0;i<str.length();i++){
            if(str1.charAt(i)>='a'&&str1.charAt(i)<='z')
                str2=str2+(char)(str1.charAt(i)-32);
            else
                str2=str2+(char)(str1.charAt(i)+32);
        }
        System.out.println(str2);
        char a='a';
        System.out.println((int)(a));
    } 
}