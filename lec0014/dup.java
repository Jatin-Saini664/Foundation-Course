import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class dup {
    static Scanner scn = new Scanner(System.in);
    public static String dup(String str,int a){
        if(a==0)
            return "\0";
        String str1=dup(str,a-1);
        if(str.charAt(a-1)==str.charAt(a)){
            return str1;
        }else{
            //str1.append(str.charAt(a-1));
            str1+=str.charAt(a-1);
        }
        return str1;
    }
    public static void main(String[] args) {
        String str=scn.nextLine();
        int a=scn.nextInt();
        String str1=dup(str,str.length()-1);
        str1+=str.charAt(str.length()-1);
        System.out.println(str1.charAt(a));
        System.out.println(str1);
    }
}