import java.util.*;

public class lexicoNum {
    public static ArrayList arrange(String s){
        if(s.length()==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        ArrayList<String> myans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i); 
            String a = s.substring(0,i)+s.substring(i+1,s.length());
            ArrayList<String> recans = arrange(a);
            for(int j=0;j<recans.size();j++){
                myans.add(ch+recans.get(j));
            }
        }
        return myans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = "0123456789";
        ArrayList<String> ans = arrange(s);
        System.out.println(ans.get(999999));
    }
}