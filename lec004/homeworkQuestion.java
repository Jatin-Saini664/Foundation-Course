import java.util.*;
class homeworkQuestion{
    public static int octalMultiplication(int n1,int n2){
        int r=0;
        int pow=1;
        int pow1=1;
        int carry=0;
        int ans=0;
        int s1=0;
        s1=(n1>n2)?n1:n2;
        n2=(n1>n2)?n2:n1;
        while(n2!=0){
            pow=1;carry=0;n1=s1;
            while(n1!=0){
                r+=(((n2%10)*(n1%10)+carry)%8)*pow;
                carry=((n2%10)*(n1%10)+carry)/8;
                n1/=10;
                pow*=10;
            }
            ans+=r*pow1;
            n2/=10;
            pow1*=10;
        }
        return ans+carry*pow;
    }
    public static int octalSubtraction(int n1,int n2){
        // int r=0;
        // int pow=1;
        // int borrow=0;
        // int s=n1;
        // boolean t=true;
        // int s1=(n1>n2)?n1:n2;
        // n2=(n1>n2)?n2:n1;
        // n1=s1;
        // int s2=n1;
        // while(n1!=0){
        //     t=false;
        //     if((n1%10-borrow)<(n2%10)){
        //         r+=((n1%10-borrow)+8-(n2%10))*pow;
        //         t=true;
        //     }
        //     else
        //         r+=((n1%10-borrow)-(n2%10))*pow;
        //     if(t==true){
        //         r+=8;
        //         borrow=1;
        //     }
        //     else
        //         borrow=0;
        //     n1/=10;
        //     n2/=10;
        //     pow*=10;
        // }
        // if(s!=s2)
        //     r=-r;
        // return r;
        int ans=0;
        int pow=1;
        int borrow=0;
        int octet=0;
        boolean isSwapped=false;
        if(n1<n2){
            int temp=n1;
            n1=n2;
            n2=temp;
            isSwapped=true;
        }
        while(n1!=0){
            int r1=n1%10;n1/=10;
            int r2=n2%10;n2/=10;
            octet=r1-r2-borrow;
            if(octet<0){
                octet+=8;
                borrow=1;
            }
            else
                borrow=0;
            ans=ans+octet*pow;
            pow*=10;
        }
        if(isSwapped)
            ans=-ans;
        return ans;
    }
    public static int octalAddition(int n1,int n2){
        // int r=0;
        // int pow=1;
        // int carry=0;
        // int s1=0;
        // s1=(n1>n2)?n1:n2;
        // n2=(n1>n2)?n2:n1;
        // n1=s1;
        // while(n1!=0){
        //     r+=(((n1%10)+(n2%10)+carry)%8)*pow;
        //     carry=((n1%10)+(n2%10)+carry)/8;
        //     n1/=10;
        //     n2/=10;
        //     pow*=10;
        // }
        // return r+pow*carry;
        int ans=0;
        int pow=1;
        int carry=0;
        int octet=0;
        while(n1!=0||n2!=0||carry!=0){
            int r1=n1%10;n1/=10;
            int r2=n2%20;n2/=10;
            octet=r1+r2+carry;
            carry=octet/10;
            octet%=10;
            ans+=octet*pow;
            pow*=10;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1;
        n1=sc.nextInt();
        int n2=sc.nextInt();
        //System.out.println(octalAddition(n1,n2));
        System.out.println(octalSubtraction(n1,n2));
        //System.out.println(octalMultiplication(n1,n2));
    }
}
