import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q59 {
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] distance = new int[N+1];
        for(int i = 1; i < N+1; i++){
            distance[i] = INF;
        }

        Edge59[] edge = new Edge59[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            edge[i] = new Edge59(S, E, V);
        }

        distance[1] = 0;
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M; j++){
                Edge59 now = edge[j];
                if(distance[now.start] != INF && distance[now.end] > distance[now.start] + now.value){
                    distance[now.end] = distance[now.start] + now.value;
                }
            }
        }

        boolean cycle = false;
        for(int i = 0; i < M; i++){
            Edge59 now = edge[i];
            if(distance[now.start] != INF && distance[now.end] > distance[now.start] + now.value){
                cycle = true;
            }
        }

        if(cycle){
            System.out.println(-1);
        }else {
            for(int i = 2; i < N+1; i++){
                if(distance[i] == INF)
                    System.out.println(-1);
                else
                    System.out.println(distance[i]);
            }
        }

        br.close();
    }
}

class Edge59{
    int start;
    int end;
    int value;
    Edge59(int start, int end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
