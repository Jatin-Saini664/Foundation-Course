import java.util.*;

public class lPalin {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String sum="";
        int count=0;
        for(int i=900;i<1000;i++){
            for(int j=900;j<1000;j++){
                sum=i*j+"";
                int a=0,b=5;
                count=0;
                while(a<b){
                    if(sum.charAt(a)!=sum.charAt(b))
                        break;
                    count++;
                    a++;b--;
                }
                if(count==3){
                    System.out.println(sum+" "+i+" "+j);
                }
            }
        }
    }
}