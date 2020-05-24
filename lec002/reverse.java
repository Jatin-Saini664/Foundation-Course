import java.util.*;
class reverse{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter The Number");
        int n = scn.nextInt();
        int ans=0;
        while(n!=0){
            ans=ans*10+(n%10);
            n=n/10;
        }
        System.out.println(ans);
    }
}