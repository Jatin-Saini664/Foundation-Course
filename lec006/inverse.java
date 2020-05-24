import java.io.*;
import java.util.*;

public class inverse{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static int[] inverse(int[] a){
      int pow=a.length;
      int next = 0;
      int c=0;
    for(int i=0;i<a.length;i++){
        if(i<pow&&a[i]<pow){
            int temp=a[a[i]];
            a[a[i]]=next+pow;
            next=a[i];
            if(temp!=i)
                i=temp-1;
        }
        else if(c<=a.length/2){
            c++;
            next=a[i+1];
            continue;
        }
        else
            break;
    }
    for(int i=0;i<a.length;i++){
        if(a[i]>pow)
            a[i]-=pow;
        else
            continue;
    }
    return null;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    display(inv);
 }

}
/*
import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      //sb.append(val + " ");
      System.out.println(val);
    }
    
  }

  public static int[] inverse(int[] a){
    int[] inv = new int[a.length];

    for(int i = 0; i < a.length; i++){
      int val = a[i];
      inv[val] = i;
    }

    return inv;
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] inv = inverse(a);
    display(inv);
 }

}
*/