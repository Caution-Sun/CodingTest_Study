import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q81 {
    public static void main(String[] args) throws IOException{
        int N, Q;
        long F[] = new long[21];
        int S[] = new int[21];
        boolean[] visited = new boolean[21];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());

        F[0] = 1;
        for(int i = 1; i < N+1; i++){
            F[i] = F[i - 1] * i;        // 팩토리얼 형태로 저장
        }

        if(Q == 1){
            long K = Long.parseLong(st.nextToken());

            for(int i = 1; i < N+1; i++){
                int cnt = 1;
                for(int j = 1; j <= N+1; j++){
                    if(visited[j])
                        continue;

                    if(K <= cnt * F[N - i]) {
                        K = K - ((cnt - 1) * F[N - i]);
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }

                    cnt++;
                }
            }

            for(int i = 1; i < N+1; i++){
                System.out.print(S[i] + " ");
            }

        }else if(Q == 2){
            long K = 1;

            for(int i = 1; i < N+1; i++){
                S[i] = Integer.parseInt(st.nextToken());
                int cnt = 0;

                for(int j = 1; j < S[i]; j++){
                    if(visited[j] == false)
                        cnt++;
                }

                K = K + cnt * F[N - i];
                visited[S[i]] = true;
            }

            System.out.println(K);
        }
    }
}
