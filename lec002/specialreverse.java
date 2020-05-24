import java.util.*;
class specialreverse{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n,r;
        System.out.println("Enter the Number");
        n=scn.nextInt();
        System.out.println("Enter The Position");
        r=scn.nextInt();
        int c=n,count=0;
        while(n!=0){
            count++;
            n/=10;
        }
        // int i=0;
        // int s=0;
        // while(count-r>i){
        //     s=s*10+c%10;
        //     c/=10;
        //     i++;
        // }
        // int d=0;
        // while(c!=0){
        //     d=d*10+c%10;
        //     c/=10;
        // }
        // int ans=0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
        // while(s!=0){
        //     ans=ans*10+s%10;
        //     s/=10;
        // }
        // while(d!=0){
        //     ans=ans*10+d%10;
        //     d/=10;
        // }
        // System.out.println(ans);
        r=r%count;
        if(r<0)
            r=r+count;
        int post=0;
        int pow=1;
        int r1=r;
        while(r>0){
            int rem=c%10;
            c=c/10;
            post=rem*pow+post;
            pow=pow*10;
            r--;
        }
        count=count-r1;
        while(count>0){
            post=post*10;
            count--;
        }
        post= post+c;
        System.out.println(post);
    }
}