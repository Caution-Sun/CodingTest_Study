import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q75 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[][] parent;
    static boolean[] visited;
    static int kmax;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            tree[S].add(E);
            tree[E].add(S);
        }

        int tmp = 1;
        kmax = 0;
        while(tmp <= N){
            tmp *= 2;
            kmax++;
        }

        parent = new int[kmax + 1][N + 1];

        BFS(1);

        for(int k = 1; k <= kmax; k++){
            for(int n = 1; n < N+1; n++){
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = executeLCA(a, b);
            System.out.println(LCA);
        }

        br.close();
    }

    static int executeLCA(int a, int b){
        if(depth[a] > depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int k = kmax; k >= 0; k--){
            if(Math.pow(2, k) <= depth[b] - depth[a]){
                if(depth[a] <= depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }

        for(int k = kmax; k >= 0; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        int LCA = a;
        if(a != b){
            LCA = parent[0][LCA];
        }

        return LCA;
    }

    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int next : tree[now_node]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = now_node;
                    depth[next] = level;
                }
            }
            count++;
            if(count == now_size){
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}
