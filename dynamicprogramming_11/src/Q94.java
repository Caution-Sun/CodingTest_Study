import java.util.Scanner;

public class Q94 {
    static int[][] D;
    static Matrix[] M;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        D = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++)
                D[i][j] = -1;
        }

        M = new Matrix[N + 1];
        for(int i = 1; i <= N; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(x, y);
        }

        System.out.println(excute(1, N));
    }

    static int excute(int s, int e){
        int result = Integer.MAX_VALUE;

        if(D[s][e] != -1)
            return D[s][e];
        if(s == e)
            return 0;
        if(s + 1 == e)
            return M[s].y * M[e].y * M[e].x;
        for(int i = s; i < e; i++)
            result = Math.min(result, excute(s, i) + excute(i + 1, e) + (M[s].y * M[i + 1].y * M[e].x));

        return result;
    }

    static class Matrix{
        private int x;
        private int y;

        Matrix(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
