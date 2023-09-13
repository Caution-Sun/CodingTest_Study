import java.util.Scanner;

public class Q45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c =sc.nextInt();

        long gcd = gcd(a,b);

        if(c%gcd != 0)
            System.out.println("01");
        else{
            int K = (int) c / (int)gcd(a,b);
            long[] ret = Excute(a, b);
            System.out.println(ret[0] * K + " " + ret[1] * K);
        }
    }

    private static long[] Excute(long a, long b){
        long[] ret = new long[2];

        if(b == 0){
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }

        long q = a / b;
        long[]v = Excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    private static long gcd(long a, long b){
        if(b == 0)
            return a;
        else
            return gcd(b, a  % b);
    }
}
