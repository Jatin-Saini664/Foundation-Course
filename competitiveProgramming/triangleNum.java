import java.util.*;
import java.math.*;

public class triangleNum {
    public static int NumberOfDivisors(int number) {
        int nod = 0;
        int sqrt1 = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrt1; i++) {
            if (number % i == 0) {
                nod += 2;
            }
        }
        // Correction if the number is a perfect square
        if (sqrt1 * sqrt1 == number) {
            nod--;
        }
        return nod;
    }

    // public static void main(String[] args) {
    //     int number = 0;
    //     int i = 1;
    //     while (NumberOfDivisors(number) < 500) {
    //         number += i;
    //         i++;
    //     }
    //     System.out.println(number);
    // }
    public static int[] ESieve(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        for(int p=2;p*p<n;p++){
            if(arr[p]==p){
                for(int i=p*p;i<n;i+=p){
                    arr[i]=1;
                }
            }
        }
        return arr;
    }
    private static int PrimeFactorisationNoD(int number, int[] primelist) {
            int nod = 1;
            int exponent;
            int remain = number;
            int i=0;
            for (; i < primelist.length; i++) { // In case there is a remainder this is a prime factor as well // The exponent of that factor is 1 if (primelist[i] * primelist[i] > number) {
                return nod * 2;
            }
            exponent = 1;
            while (remain % primelist[i] == 0) {
                exponent++;
                remain = remain / primelist[i];
            }
            nod *= exponent;
            //If there is no remainder, return the count
            if (remain == 1) {
                return nod;
            }
            return nod;
        }
    public static void main(String[] args) {
        int number = 1;
        int i = 2;
        int cnt = 0;
        int Dn1 = 2;
        int Dn = 2;
        int[] primelist = ESieve(75000);

        while (cnt < 500) {
            if (i % 2 == 0) {
                Dn = PrimeFactorisationNoD(i + 1, primelist);
                cnt = Dn * Dn1;
            } else {
                Dn1 = PrimeFactorisationNoD((i + 1) / 2, primelist);
                cnt = Dn * Dn1;
            }
            i++;
        }
        number = i * (i - 1) / 2;
        System.out.println(number);
    }
}