import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q56 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Edge56>[] A = new ArrayList[V+1];
        for(int i = 1; i < V+1; i++){
            A[i] = new ArrayList<Edge56>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            A[startNode].add(new Edge56(endNode, value));
        }

        int[] distance = new int[V+1];
        for(int i = 1; i < V+1; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[K] = 0;

        boolean[] visited = new boolean[V+1];
        for(int i = 1; i < V+1; i++){
            visited[i] = false;
        }

        PriorityQueue<Edge56> queue = new PriorityQueue<Edge56>();
        queue.add(new Edge56(K,0));
        while (!queue.isEmpty()) {
            Edge56 now = queue.poll();
            int now_Node = now.targetNode;

            if(visited[now_Node])
                continue;
            visited[now_Node] = true;

            for(int i = 0; i < A[now_Node].size(); i++){
                Edge56 tmp = A[now_Node].get(i);
                int next_Node = tmp.targetNode;
                int value = tmp.value;

                if(distance[next_Node] > distance[now_Node] + value){
                    distance[next_Node] = distance[now_Node] + value;
                    queue.add(new Edge56(next_Node, distance[next_Node]));
                }
            }
        }

        for(int i = 1; i < V+1; i++){
            if(distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }

        br.close();
    }
}
class Edge56 implements Comparable<Edge56>{
    int targetNode;
    int value;
    Edge56(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Edge56 o) {
        return this.value - o.value;
    }
}
