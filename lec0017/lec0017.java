import java.util.*;

class lec0017{
    static Scanner scn = new Scanner(System.in);
    public static void mazepath(int startc,int startr,int endc,int endr,String str){
        if(startc==endc&&startr==endr){
            System.out.println(str);
            return;
        }
        for(int i=1;i<=endc;i++){
            if(startc+i<=endc)
            mazepath(startc+i,startr,endc,endr,str+'h'+i+"");
        }
        for(int i=1;i<=endr;i++){
            if(startr+i<=endr)
                mazepath(startc,startr+i,endc,endr,str+'v'+i+"");
        }
        for(int i=1,j=1;i<=endc&&j<=endr;i++,j++){
            if(startc+i<=endc&&startr+j<=endr)
                mazepath(startc+i,startr+j,endc,endr,str+'d'+i+"");
        }
    }
    public static ArrayList mazepath1(int startc,int startr,int endc,int endr){
        if(startc==endc&&startr==endr){
            //System.out.println(str);
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans= new ArrayList<>();
        for(int i=1;startc+i<=endc;i++){
            ArrayList<String> resans=mazepath1(startc+i,startr,endc,endr);
            for(int j=0;j<resans.size();j++){
                myans.add("h"+i+resans.get(j));
            }
        }
        for(int i=1;startr+i<=endr;i++){
            ArrayList<String> resans=mazepath1(startc,startr+i,endc,endr);
            for(int j=0;j<resans.size();j++){
                myans.add("v"+i+resans.get(j));
            }
        }
        for(int i=1,j=1;startc+i<=endc&&startr+j<=endr;i++,j++){
            ArrayList<String> resans=mazepath1(startc+i,startr+j,endc,endr);
            for(int k=0;k<resans.size();k++)
                myans.add("d"+i+resans.get(k));
        }
        return myans;
    }
    public static ArrayList staircase(int a){
        if(a==0){
            ArrayList<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans=new ArrayList<>();
        for(int i=1;i<=3;i++){
            if(a-i>=0){
                ArrayList<String> recans=staircase(a-i);
                for(int j=0;j<recans.size();j++){
                    myans.add(i+recans.get(j));
                }
            }
        }
        return myans;
    }
    public static void main(String[] args){
        //mazepath(0,0,2,2,"");
        ArrayList<String> ans=mazepath1(1,1,3,3);
        System.out.println(ans);
        System.out.println(ans.size());
        //System.out.println(staircase(4));
    }
}