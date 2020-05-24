/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
public
    static void square(int[] arr, int n, int g)
    {
        int f = 0;
        int i1 = arr.length;
        int ans = 0, h = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (arr[i] % 4 == 0)
            {
                n += ((arr.length - i) * (i + 1));
                i1 = i;
                n += (ans);
                ans = 0;
                f = 0;
                h = 0;
            }
            else if (arr[i] % 2 == 0 && arr[i] % 4 != 0 && g > 0)
            {
                // if(g%2==0){
                //     n+=(ans*f);
                //     ans=(i1-i);g--;
                // }else{
                //     n+=(ans*f);
                //     ans=(i1-i);g--;
                //     f=1;
                // }
                if (f != 0)
                    n += ans;
                f++;
                ans = (i1 - i);
                g--;
                h = 0;
            }
            else if (arr[i] % 2 != 0)
            {
                h++;
                n += (h - 1);
                // if(g%2==0)
                //     f++;
                if (i == 0 && f != 0)
                    n += ans;
            }
        }
        System.out.println(n);
    }
public
    static void main(String[] args) throws java.lang.Exception
    {
        Scanner scn = new Scanner(System.in);
        int p = scn.nextInt();
        while (p != 0)
        {
            int n = scn.nextInt();
            int[] arr = new int[n];
            int c = 0, g = 0;
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = scn.nextInt();
                if (arr[i] % 2 != 0)
                    c++;
                else
                {
                    if (arr[i] % 4 != 0)
                        g++;
                }
            }
            square(arr, c, g);
            p--;
        }
    }
}