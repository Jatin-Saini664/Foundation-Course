import java.util.*;

class lec0015{
    static Scanner scn = new Scanner(System.in);
    public static int[] rem(int[] arr,int a,int i,int count){
        if(i==arr.length){
            int[] arr1 = new int[count];
            return arr1;
        }
        if(arr[i]==a)
            count++;
        int[] arr2=rem(arr,a,i+1,count);
        if(arr[i]==a){
            arr2[count-1]=i;
        }
        return arr2;
    }
    public static void subseq(String str,String ans){
        // if(a==0){
        //     return;
        // }
        // subseq(str,a-1);
        // int n=a;
        // int i=0;
        // while(n!=0){
        //     int rem=n%2;
        //     if(rem==1){
        //         System.out.print(str.charAt(i));
        //     }
        //     i++;
        //     n/=2;
        // }
        // System.out.println();
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        String res=str.substring(1);
        subseq(res,ans+ch);
        subseq(res,ans);
    }
    public static ArrayList subseq1(String str){
        if(str.length()==0){
            ArrayList<String> str1=new ArrayList<>();
            str1.add("");
            return str1;
        }
        String res=str.substring(1);
        ArrayList<String> recAns=subseq1(res);
        ArrayList<String> myans=new ArrayList<>();
        char ch=str.charAt(0);
        for(int i=0;i<recAns.size();i++){
            myans.add(ch+recAns.get(i));
        }
        for(int i=0;i<recAns.size();i++){
            myans.add(recAns.get(i));
        }
        return myans;
    }
    public static void stairs(int a,String str){
        if(a==0){
            System.out.println(str);
            return;
        }
        if(a-1>=0)
        stairs(a-1,str+"1");
        //System.out.println();
        // System.out.print(2);
        if(a-2>=0)
        stairs(a-2,str+"2");
        //System.out.println();
        // System.out.print(3);
        //System.out.println();
        if(a-3>=0)
        stairs(a-3,str+"3");
        //System.out.println();
        //System.out.println();
    }
    public static ArrayList stairsr(int a){
        if(a==0){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans = new ArrayList<>();
        if(a-1>=0){
            ArrayList<String> recans=stairsr(a-1);
            for(int i=0;i<recans.size();i++){
                myans.add('1'+recans.get(i));
            }
        }
        if(a-2>=0){
            ArrayList<String> recans1=stairsr(a-2);
            for(int i=0;i<recans1.size();i++){
                myans.add('2'+recans1.get(i));
            }
        }
        if(a-3>=0){
            ArrayList<String> recans2=stairsr(a-3);
            for(int i=0;i<recans2.size();i++){
                myans.add('3'+recans2.get(i));
            }
        }
        return myans;
    }
    public static ArrayList allstairs(int a){
        if(a==0){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans=new ArrayList<>();
        for(int i=1;i<=a;i++){
            if(a-i>=0){
                ArrayList<String> recans=allstairs(a-i);
                for(int j=0;j<recans.size();j++){
                    myans.add((char)(i+'0')+recans.get(j));
                }
            }
        }
        return myans;
    }
    public static void main(String[] args){
        // int size=scn.nextInt();
        // int[] arr = new int[size];
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=scn.nextInt();
        // }
        // int data=scn.nextInt();
        // int[] arr1=rem(arr,data,0,0);
        // for(int i=0;i<arr1.length;i++){
        //     System.out.print(arr1[i]+" ");
        // }
        // String str=scn.nextLine();
        // //subseq(str,"");
        // ArrayList<String> ans=subseq1(str);
        // System.out.print(ans);
        int a=scn.nextInt();
        //stairs(a,"");
        // ArrayList<String> ans=stairsr(a);
        // System.out.print(ans);
        ArrayList<String> ans1=allstatirs(a);
        System.out.println(ans);
    }
}