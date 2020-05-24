import java.util.*;
class lec0016{
    static Scanner scn = new Scanner(System.in);
    public static void allstring(String[] arr,String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }
        int num=str.charAt(0)-'0';
        String word=arr[num];
        String res=str.substring(1);
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            //ans=ans+ch wont work
            allstring(arr,res,ans+ch);
        }
    }
    public static ArrayList nokia(String[] arr,String str){
        if(str.length()==0){
            ArrayList<String> ans1=new ArrayList<>();
            ans1.add("");
            return ans1;
        }
        int num=str.charAt(0)-'0';
        String word=arr[num];
        String res=str.substring(1);
        ArrayList<String> resans=nokia(arr,res);
        ArrayList<String> myans = new ArrayList<>();
        for(int j=0;j<word.length();j++){
            char ch=word.charAt(j);
        for(int i=0;i<resans.size();i++){
            myans.add(ch+resans.get(i));
        }
    }
        return myans;
    }
    public static void nokia1(String[] arr,String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }
        int ch=str.charAt(0)-'0';
        ch-=1;
        String word=arr[ch];
        String res=str.substring(1);
        for(int i=0;i<word.length();i++){
            char ch1=word.charAt(i);
            nokia1(arr,res,ans+ch1);
        }
        if(str.length()>=2){
        int ch2=Integer.parseInt(str.substring(0,2));
        ch2-=1;
        if(ch2<=11){
            String word1=arr[ch2];
            String res1=str.substring(2);
            for(int i=0;i<word1.length();i++){
                char ch1=word1.charAt(i);
                nokia1(arr,res1,ans+ch1);
            }
        }
        }
    }
    public static ArrayList nokia1(String[] arr,String str){
        if(str.length()==0){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans=new ArrayList<>();
        int ch=str.charAt(0)-'0';
        ch-=1;
        String word=arr[ch];
        String res=str.substring(1);
        ArrayList<String> recans=nokia1(arr,res);
        for(int i=0;i<word.length();i++){
            char ch1=word.charAt(i);
            for(int j=0;j<recans.size();j++){
                myans.add(ch1+recans.get(j));
            }
        }
        if(str.length()>=2){
            int ch2=Integer.parseInt(str.substring(0,2));
            ch2-=1;
            if(ch2<=11){
                String word1=arr[ch2];
                String res1=str.substring(2);
                ArrayList<String> recans1=nokia1(arr,res1);
                for(int i=0;i<word1.length();i++){
                    char ch1=word1.charAt(i);
                    for(int j=0;j<recans1.size();j++){
                        myans.add(ch1+recans1.get(j));
                    }
                }
            }
        }
        return myans;
    }
    public static int paths(String ans,int startr,int startc,int endr,int endc){
        if(startc==endc&&startr==endr){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        if(startc+1<=endc){
            count+=paths(ans+'h',startr,startc+1,endr,endc);
        }
        if(startr+1<=endr){
            count+=paths(ans+'v',startr+1,startc,endr,endc);
        }
        return count;
    }
    public static ArrayList mazepaths(int startc,int startr,int endc,int endr){
        if(startc==endc&&startr==endr){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans=new ArrayList<>();
        if(startc+1<=endc){
            ArrayList<String> recans=mazepaths(startc+1,startr,endc,endr);
            for(int i=0;i<recans.size();i++){
                myans.add('h'+recans.get(i));
            }
        }
        if(startr<=endr){
            ArrayList<String> recans1=mazepaths(startc,startr+1,endc,endr);
            for(int i=0;i<recans1.size();i++){
                myans.add('v'+recans1.get(i));
            }
        }
        return myans;
    }
    public static void allpermutation(String ans,String path){
        if(ans.length()==0){
            System.out.println(path);
            return;
        }
        for(int i=ans.length()-1;i>=0;i--){
            char ch=ans.charAt(i);
            String resans=ans.substring(0,i)+ans.substring(i+1);
            allpermutation(resans,ch+path);
        }
        // char ch1='\0';
        // String resans1="";
        // if(resans.length()>=2){
        //     ch1=resans.charAt(0);
        //     resans1=resans.substring(1)+ch1;
        //     //System.out.println(resans1);
        // }
        // allpermutation(resans1,ch+path);
    }
    public static ArrayList allpermut(String str){
        if(str.length()==0){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String res = str.substring(0,i)+str.substring(i+1);
            ArrayList<String> recans=allpermut(res);
            for(int j=0;j<recans.size();j++){
                myans.add(ch+recans.get(j));
            }
        }
        return myans;
    }
    public static void main(String[] args){
        // String str=scn.nextLine();
        // String[] arr ={",:","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // // allstring(arr,"852","");
        // ArrayList<String> ans=nokia(arr,"852");
        // System.out.print(ans);
        // nokia keypad Extended version
        String[] arr={".:!","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz","$;<","/?>","~`&"};
        //nokia1(arr,"112","");
        ArrayList<String> ans=nokia1(arr,"112");
        System.out.println(ans);
        System.out.println(ans.size());
        //System.out.println(paths("",0,0,2,2));
        // ArrayList<String> ans=mazepaths(0,0,2,2);
        // int count=ans.size();
        // System.out.println(ans);
        // System.out.println(count);
        //allpermutation("abc","");
        //ArrayList<String> ans=allpermut("abc");
        //System.out.println(ans);
    }
}