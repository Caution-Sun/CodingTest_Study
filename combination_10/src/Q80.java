import java.util.Scanner;

public class Q80 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = 0; int N; int K;

        N = sc.nextInt();

        int[] D = new int[N];

        for(int i = 0; i < N; i++){
            D[i] = sc.nextInt();
            T += D[i];
        }

        K = sc.nextInt();

        double answer = 0;

        for(int i = 0 ; i < N; i++){

            double p = 0.0;

            if(D[i] >= K){
                p = 1.0;
                for(int j = 0; j < K; j++){
                    p *= (double) (D[i] - j) / (T - j);
                }
            }

            answer += p;
        }

        System.out.println(answer);
    }

    /*
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = 0; int N; int K;

        N = sc.nextInt();

        int[] C = new int[N];

        for(int i = 0; i < N; i++){
            C[i] = sc.nextInt();
            T += C[i];
        }

        K = sc.nextInt();

        int[][] D = new int[T+1][T+1];

        for(int i = 0; i < T+1; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for(int i = 2; i < T+1; i++){
            for(int j = 1; j < i; j++){
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        double answer = 0.0;

        for(int i = 0; i < N; i++){
            double p = 0.0;

            if(C[i] >= K){
                p = (double)D[C[i]][K];
            }

            answer += p;
        }

        answer = answer / (double)D[T][K];

        System.out.println(answer);

    }

     */
}
