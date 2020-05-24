import java.util.*;

class lec0018 {
    static Scanner scn = new Scanner(System.in);

    public static int mazepath(int[][] arr, int startc, int startr, int endc, int endr, String str) {
        if (startc == endc && startr == endr) {
            System.out.println(str);
            return 1;
        }
        int count = 0;
        if (startr - 1 >= 0 && arr[startr - 1][startc] == 0) {
            arr[startr][startc] = 1;
            count += mazepath(arr, startc, startr - 1, endc, endr, str + 'u');
            arr[startr][startc] = 0;
        }
        if (startc - 1 >= 0 && arr[startr][startc - 1] == 0) {
            arr[startr][startc] = 1;
            count += mazepath(arr, startc - 1, startr, endc, endr, str + 'l');
            arr[startr][startc] = 0;
        }
        if (startr + 1 <= endr && arr[startr + 1][startc] == 0) {
            arr[startr][startc] = 1;
            count += mazepath(arr, startc, startr + 1, endc, endr, str + 'd');
            arr[startr][startc] = 0;
        }
        if (startc + 1 <= endc && arr[startr][startc + 1] == 0) {
            arr[startr][startc] = 1;
            count += mazepath(arr, startc + 1, startr, endc, endr, str + 'r');
            arr[startr][startc] = 0;
        }
        return count;
    }

    public static ArrayList mazepath1(int[][] arr, int startc, int startr, int endc, int endr) {
        if (startr == endr && startc == endc) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        arr[startr][startc] = 1;
        ArrayList<String> myans = new ArrayList<>();
        if (startr - 1 >= 0 && arr[startr - 1][startc] == 0) {
            // arr[startr][startc] = 1;
            ArrayList<String> recans = mazepath1(arr, startc, startr - 1, endc, endr);
            for (int i = 0; i < recans.size(); i++) {
                myans.add('u' + recans.get(i));
            }
            // arr[startr][startc] = 0;
        }
        if (startc - 1 >= 0 && arr[startr][startc - 1] == 0) {
            // arr[startr][startc] = 1;
            ArrayList<String> recans = mazepath1(arr, startc - 1, startr, endc, endr);
            for (int i = 0; i < recans.size(); i++) {
                myans.add('l' + recans.get(i));
            }
            // arr[startr][startc] = 0;
        }
        if (startr + 1 <= endr && arr[startr + 1][startc] == 0) {
            // arr[startr][startc] = 1;
            ArrayList<String> recans = mazepath1(arr, startc, startr + 1, endc, endr);
            for (int i = 0; i < recans.size(); i++) {
                myans.add('d' + recans.get(i));
            }
            // arr[startr][startc] = 0;
        }
        if (startc + 1 <= endc && arr[startr][startc + 1] == 0) {
            // arr[startr][startc] = 1;
            ArrayList<String> recans = mazepath1(arr, startc + 1, startr, endc, endr);
            for (int i = 0; i < recans.size(); i++) {
                myans.add('r' + recans.get(i));
            }
            // arr[startr][startc] = 0;
        }
        arr[startr][startc] = 0;
        return myans;
    }

    public static void lexico(int a, int b, int ans, int count) {
        if (a == -1) {
            System.out.print(ans + "  ");
            return;
        }
        // int n=a;
        // for(int i=0;i<=9;i++){
        // a+=i;
        // a=n;
        // for(int j=0;;j++){
        // int a1=j;
        // int pow1=1;
        // if(a>b)
        // break;
        // while(a1!=0){
        // a*=10;
        // if(a>b){
        // a/=10;
        // pow1/=10;
        // break;
        // }
        // pow1*=10;
        // a1--;
        // }
        // int ans1=-1;
        // int pow=1;
        // int ch=0;
        // while(a!=0){
        // ch=a%10;
        // if(a/10!=0)
        // ans1=ans1+ch*pow;
        // a/=10;
        // pow*=10;
        // }
        // if(ch==i){
        // ans+=ch*pow1;
        // lexico(ans1,b,ans);
        // if(ans1*10<=b){
        // a*=10;
        // ans*=10;
        // }
        // }
        // }
        // }
        if(count<=b){
        int ans1 = a;
        lexico(-1, b, ans1,count+1);
        int ans2 = ans1 * 10;
        // if(ans2==b||ans1==b){
        // return;
        // }
        if (ans2 <= b) {
            lexico(ans2, b, 0,count);
            // ans2+=1;
            ans1 += 1;
            for (int i = 0; i < 9; i++) {
                if (ans1 + i <= b && (ans1 % 10) + i <= 9) {
                    lexico(ans1 + i, b, 0,count);
                } else
                    break;
            }
        } else if (ans1 + 1 < b && (ans1) % 10 == 0) {
            ans1 += 1;
            for (int i = 0; ans1 + i <= b && (ans1 % 10) + i <= 9; i++) {
                lexico(ans1 + i, b, 0,count);
            }
        }
    }
    }

    public static void main(String[] args) {
        // int[][] arr = new int[4][4];
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // arr[i][j] = scn.nextInt();
        // }
        // }
        // System.out.println(mazepath(arr, 0, 0, 3, 3, ""));
        lexico(1, 30, 0,0);
    }
}