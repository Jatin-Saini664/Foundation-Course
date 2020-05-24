import java.util.*;

class specialQ{
    static Scanner scn = new Scanner(System.in); 
    public static void lcmHcf(int sum){
        int a=0,b=0,c=0;
        for(int i=2;i<sum/2;i++){
            c=sum-i;
            if(c%i==0){
                a=i;
                b=i*(c/i);
                break;
            }
        }
        if(a==0&&b==0){
            a=1;
            b=sum-1;
        }
        System.out.println(a);
        System.out.println(b);
    }
    public static void xorsum(int xor,int sum){
        int c=0;
        int start=0;
        int end=sum;
        while(start<=end){
            int i=(start+end)/2;
            c=sum-i;
            int d=(c|i)&(~c|~i);
            if(d>xor){
                end=i-1;
            }
            else if(d<xor){
                start=i+1;
            }
            else{
                System.out.println(i);
                System.out.println(c);
                break;
            }
        }
    }
    public static void nextPermutation(int[] arr){
        int i=arr.length-2;
        while(i>=0&&arr[i]>=arr[i+1]){
            i--;
        }
        int j=arr.length-1;
        while(j>=0&&arr[i]>=arr[j]){
            j--;
        }
        swap(arr,i,j);
        reverse(arr,i+1);
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }
    public static void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    public static void reverse(int[] arr,int start){
        for(int i=start;i<arr.length-1;i++){
            swap(arr,i,i+1);
        }
    }
    public static void numbersub(int x,String arr){
        int s=0;
        int pow=1;
        while(x!=0){
            s+=(x%2)*pow;
            pow*=10;
            x/=2;
        }
        x=0;
        int res=0;
        for(int i=1;i<arr.length();i++){
            String str=arr.substring(x,i);
            int b=Integer.parseInt(str);
            if(b>=s){
                int length=arr.substring(i-1).length();
                res+=length;
                x++;
            }
        }
        System.out.println(res);
    }
    public static void rabbuLovesCarrot(int n,int a){
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int d=1;
        int pd=0;
        for(int i=0;i<n;i++){
            pd=d;
            if(i==0)
                d=arr[i]-a;
            else
                d=arr[i]-arr[i-1];
            if(d<pd){
                if(pd%d!=0){
                    int t=d-1;
                    while(t!=0){
                        if(pd%t==0&&d%t==0){
                            d=t;
                            pd=t;
                            break;
                        }
                        t--;
                    }
                }
            }else{
                if(d%pd!=0){
                    int t=pd-1;
                    while(t!=0){
                        if(pd%t==0&&d%t==0){
                            d=t;
                            pd=t;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(pd);
    }
    public static void main(String[] args){
        //int sum=scn.nextInt();
        //lcmHcf(sum);
        // int xor=scn.nextInt();
        // int sum=scn.nextInt();
        // xorsum(xor,sum);
        // int[] arr={4,2,3,9,8,7,5,3};
        // nextPermutation(arr);
        // int n=scn.nextInt();
        // int a=scn.nextInt();
        // rabbuLovesCarrot(n,a);
        int n=scn.nextInt();
        int x=scn.nextInt();
        String arr=scn.nextLine();
        numbersub(x,arr);
    }
}