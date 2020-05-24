import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.Math;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		Scanner scn = new Scanner(System.in);
		int a, w1, w2, w3, c=0,s1,s2,s3;
		a=scn.nextInt();
		w1=scn.nextInt();
		w2=scn.nextInt();
		w3=scn.nextInt();
		w1=(w1>w3)?w1:w3;
		w3=(w1>w3)?w3:w1;
        if(w1%a!=0)
            s1=(w1/a)+(w1%a);
        else
            s1=(w1/a);
        if(w2%a!=0)
            s2=(w2/a)+(w2%a);
        else
            s2=(w2/a);
        if(w3%a!=0)
            s3=(w3/a)+(w3%a);
        else
            s3=(w3/a);
	    if(a*s1>=w1+w2){
            if(a*s1>=w1+w2+w3)
                c++;
            else{
	            c++;
                c+=s3;
            }
	    }else if(a*s2>=w2+w3){
            c+=s1;
		   c+=s2;
		   c++;
	    }else{
            c+=s1;
		   c+=s2;
		   c+=s3;
	    }
		System.out.println(c);
	}
}
