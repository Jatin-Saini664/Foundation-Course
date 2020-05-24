import java.util.*;

class homeworkQuestion{
    static Scanner scn = new Scanner(System.in);
    public static void palindrome(String str){
        int b=str.length()-1;
        boolean flag=true;
        for(int i=0;i<b;i++){
            if(str.charAt(i)!=str.charAt(b)){
                System.out.print("Not a Palindrome");
                flag=false;
                break;
            }else
                b--;
        }
        if(flag)
            System.out.println("Palindrome");
    }
    public static void palindromeSubstring(String str){
        String str1="";
        for(int i=0;i<str.length();i++){
            for(int j=i;j<=str.length();j++){
                str1=str.substring(i,j);
                int b=str1.length()-1;
                int a=0;
                boolean flag=true;
                while(a<b){
                    if(str1.charAt(a)!=str1.charAt(b)){
                        flag=false;
                        break;
                    }else
                        a++;b--;
                }
                if(flag)
                    System.out.println(str1);
            }
        }
    }
    public static void charDifference(String str){
        String str1="";
        for(int i=0;i<str.length();i++){
            str1+=str.charAt(i);
            if(i+1<str.length()){
                str1+=((int)(str.charAt(i+1))-(int)(str.charAt(i)));
            }
        }
        System.out.println(str1);
    }
    public static void main(String[] args){
        //String str=new String();
        String str=scn.nextLine();
        //palindrome(str);
        //palindromeSubstring(str);
        charDifference(str);
    }
}