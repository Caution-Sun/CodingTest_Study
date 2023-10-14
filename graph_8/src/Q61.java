import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q61 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] distance = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(i == j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = 10000001;
            }
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(distance[S][E] > V)
                distance[S][E] = V;
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(distance[i][j] == 10000001)
                    System.out.print(0 + " ");
                else
                    System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}
