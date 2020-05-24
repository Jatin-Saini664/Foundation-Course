import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long a = scn.nextLong();
        long b = scn.nextLong();
        long a1 = a, b1 = b;
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        System.out.println(a);
        long res = a1, i = 2;
        while (res % a1 != 0 || res % b1 != 0) {
            res = a1 * i;
            i++;
        }
        System.out.println(res);
    }
}