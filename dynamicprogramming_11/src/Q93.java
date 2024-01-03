import java.util.Scanner;

public class Q93 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int D[][][] = new int[10001][5][5];
        int mp[][] = {{0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}};

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++)
                    D[k][i][j] = 100001 * 4;
            }
        }
        D[0][0][0] = 0;

        int n = 0;
        int s = 1;

        while (true){
            n = sc.nextInt();
            if(n == 0)
                break;

            for(int i = 0; i < 5; i++){
                if (n == i)
                    continue;
                for(int j = 0; j < 5; j++){
                    D[s][i][n] = Math.min(D[s][i][n], D[s - 1][i][j] + mp[j][n]);
                }
            }

            for(int i = 0; i < 5; i++){
                if(n == i)
                    continue;
                for(int j = 0; j < 5; j++){
                    D[s][n][i] = Math.min(D[s][n][i], D[s - 1][j][i] + mp[j][n]);
                }
            }

            s++;
        }

        s--;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                min = Math.min(min, D[s][i][j]);
            }
        }

        System.out.println(min);
    }
}
