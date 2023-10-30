import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q63 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(i == j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = 100000001;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            distance[s][e] = 1;
            distance[e][s] = 1;
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }

        int Min = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 1; i < N+1; i++){

            int Kevin = 0;

            for(int j = 1; j < N+1; j++){
                Kevin += distance[i][j];
            }

            if(Min > Kevin){
                Min = Kevin;
                result = i;
            }
        }

        System.out.println(result);

        br.close();
    }
}
