import java.util.Scanner;

public class Q95 {
    static final int INF = 1000000 * 16 + 1;
    static int N;
    static int[][] W;
    static int [][] D;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        W = new int[16][16];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                W[i][j] = sc.nextInt();
        }

        D = new int[16][1 << 16];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < (1 << N); j++)
                D[i][j] = INF;
        }

        System.out.println(tsp(0, 1));
    }

    private static int tsp(int c, int v){
        // 모든 도시를 방문했을 때
        if(v == (1 << N) - 1){
            // 시작 도시로 돌아갈 수 없을 때
            if(W[c][0] == 0)
                return INF;
            // 시작 도시로 돌아갈 수 있을 때
            else
                return W[c][0];
        }

        // 이미 계산 했을 때
        if(D[c][v] != INF)
            return D[c][v];

        for(int i = 0; i < N; i++){
            // 방문한 적이 없고, 갈 수 있는 도시일 때
            if((v & (1 << i)) == 0 && W[c][i] != 0)
                D[c][v] = Math.min(D[c][v], tsp(i, (v | (1 << i))) + W[c][i]);
        }

        return D[c][v];
    }
}
