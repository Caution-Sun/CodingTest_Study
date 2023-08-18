import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q28 {
    static int N;
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());

            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1)
                    break;

                int value = Integer.parseInt(st.nextToken());
                A[S].add(new Edge(e, value));
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);

        int biggest = 1;
        for(int i = 2; i <= N; i++){
            if(distance[biggest] < distance[i])
                biggest = i;
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(biggest);

        Arrays.sort(distance);
        System.out.println(distance[N]);

    }

    private static void BFS(int S){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(S);
        visited[S] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(Edge i : A[now]){
                int e = i.e;
                int value = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + value;
                }
            }
        }
    }
}
class Edge{
    int e;
    int value;
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}
