import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q62 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N+1][N+1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k < N + 1; k++){
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < N + 1; j++){
                    if(distance[i][k] == 1 && distance[k][j] == 1)
                        distance[i][j] = 1;
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}
