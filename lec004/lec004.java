import java.util.*;
class lec004{
    public static int decimalToBinary(int n){
        int r=0;
        int pow=1;
        while(n!=0){
            r+=(n%2)*pow;
            n/=2;
            pow*=10;
        }
        return r;
    }
    public static int binaryToDecimal(int n){
        int r=0;
        int pow=1;
        while(n!=0){
            r+=(n%10)*pow;
            n/=10;
            pow*=2;
        }
        return r;
    }
    public static int decimalToOctal(int n){
        int r=0;
        int pow=1;
        while(n!=0){
            r+=(n%8)*pow;
            n/=8;
            pow*=10;
        }
        return r;
    }
    public static int octalToDecimal(int n){
        int r=0;
        int pow=1;
        while(n!=0){
            r+=(n%10)*pow;
            n/=10;
            pow*=8;
        }
        return r;
    } 
    public static int anyBaseToDecimal(int n, int sb){
        int r=0;
        int pow=1;
        while(n!=0){
            r+=(n%10)*pow;
            n/=10;
            pow*=sb;
        }
        return r;
    }
    public static int decimalToAnyBase(int abd,int db){
        int r=0;
        int pow=1;
        while(abd!=0){
            r+=(abd%db)*pow;
            abd/=db;
            pow*=10;
        }
        return r;
    } 
    public static int anyBaseToAnyBase(int n, int sb, int db){
        int abd=anyBaseToDecimal(n,sb);
        int ans=decimalToAnyBase(abd,db);
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt(); 
        int sb=sc.nextInt();
        int db=sc.nextInt();
        System.out.println(decimalToBinary(n));
        // System.out.println(binaryToDecimal(n));
        //System.out.println(decimalToOctal(n));
        //System.out.println(octalToDecimal(n));
        //System.out.println(anyBaseToAnyBase(n,sb,db));
    }
}