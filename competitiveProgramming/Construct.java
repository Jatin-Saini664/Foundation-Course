import java.util.*;

class Construct{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int p=scn.nextInt();
        while(p!=0){
            int n=scn.nextInt();
            Queue<Integer> qu = new LinkedList<>();
            int[] arr = new int[n];
            qu.add(1);
            qu.add(n);
            int i=1;
            while(qu.size()>0){
                int a = qu.remove();
                int b = qu.remove();
                int c=0;
                // System.out.println(a+" "+b);
                if(((b-a)+1)%2!=0){
                    arr[(b+a)/2-1]=i;
                    c=(b+a)/2;
                    // System.out.println(c);
                }else{
                    arr[((b+a)-1)/2-1]=i;
                    c=(b+a-1)/2;
                    // System.out.println(c);
                }
                if(b!=a&&b-c>c-a){
                    if(c-a==0){
                        qu.add(c+1);qu.add(b);
                    }else{
                        qu.add(c+1);qu.add(b);qu.add(a);qu.add(c-1);
                    }
                }else if(b!=a&&c-a>b-c){
                    if(b-c==0){
                        qu.add(a);qu.add(c-1);
                    }else{
                    qu.add(a);qu.add(c-1);qu.add(c+1);qu.add(b);
                    }
                }else{
                    if(b!=a){
                        qu.add(a);qu.add(c-1);qu.add(c+1);qu.add(b);
                    }
                }
                i++;
            }
            for(i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            p--;
        }
    }
}