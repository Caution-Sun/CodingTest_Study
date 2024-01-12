import java.util.Scanner;

public class Q100 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] L = new long[N + 1][2];

        for(int i = 0; i < N; i++){
            L[i][0] = sc.nextInt();
            L[i][1] = sc.nextInt();
        }

        L[N][0] = L[0][0];
        L[N][1] = L[0][1];

        double result = 0;
        for(int i = 0; i < N; i++){
            result += (L[i][0] * L[i + 1][1]) - (L[i + 1][0] * L[i][1]);
        }

        String answer = String.format("%.1f", Math.abs(result) / 2.0);
        System.out.println(answer);
    }
}
