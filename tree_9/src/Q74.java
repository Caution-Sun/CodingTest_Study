import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q74 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i < N + 1; i++){
            tree[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < N - 1; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            tree[s].add(e);
            tree[e].add(s);
        }

        BFS(1);

        int M = sc.nextInt();

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(executeLCA(a, b));
        }
    }

    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        parent[node] = 0;
        depth[node] = 0;

        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!queue.isEmpty()){
            int now_node = queue.poll();
            for(int next : tree[now_node]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);

                    parent[next] = now_node;
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

    static int executeLCA(int a, int b){
        if(depth[a] > depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (depth[a] != depth[b]){
            b = parent[b];
        }

        while(a != b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
