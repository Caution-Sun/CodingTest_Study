import java.util.Scanner;

public class Q41 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.next());
        long result = n;

        for(long p = 2; p <= Math.sqrt(n); p++){
            if(n % p == 0){
                result = result - result / p;

                while(n % p == 0){
                    n = n / p;
                }
            }
        }

        if(n > 1)
            result = result - result / n;

        System.out.println(result);
    }
}
