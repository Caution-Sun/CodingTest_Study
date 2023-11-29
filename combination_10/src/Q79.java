import java.util.Scanner;

public class Q79 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] D = new int[31][31];

        for(int i = 0; i < 31; i++){
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for(int i = 2; i < 31; i++){
            for(int j = 1; j < i; j++){
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(D[M][N]);
        }
    }
}
