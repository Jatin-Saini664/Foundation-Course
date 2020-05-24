import java.util.*;

public class nthPrime {
    static int max=10000000;
    static ArrayList<Integer> primes = new ArrayList<>();
    public static void seiveOfErastosthenes() {
        boolean[] isPrime = new boolean[max];
        for(int i=0;i<max;i++)
            isPrime[i]=true;
        for(int p=2;p*p<max;p++){
            if(isPrime[p]==true){
                for(int i=p*p;i<max;i+=p)
                    isPrime[i]=false;
            }
        }
        for(int p=2;p<max;p++){
            if(isPrime[p]==true)
                primes.add(p);
        }
    }
    public static void main(String[] args) {
        seiveOfErastosthenes();
        System.out.println(primes.get(10000));
    }
}