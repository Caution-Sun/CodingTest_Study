import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q57 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge57>[] A = new ArrayList[N+1];
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++){
            A[i] = new ArrayList<Edge57>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            A[S].add(new Edge57(E, V));
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N+1; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[startNode] = 0;

        PriorityQueue<Edge57> queue = new PriorityQueue<Edge57>();
        queue.add(new Edge57(startNode, 0));

        while (!queue.isEmpty()){
            Edge57 now = queue.poll();
            int now_Node = now.targetNode;

            if(visited[now_Node])
                continue;
            visited[now_Node] = true;

            for(int i = 0; i < A[now_Node].size(); i++){
                Edge57 tmp = A[now_Node].get(i);
                int next_Node = tmp.targetNode;
                int value = tmp.value;

                if(distance[next_Node] > distance[now_Node] + value){
                    distance[next_Node] = distance[now_Node] + value;
                    queue.add(new Edge57(next_Node, distance[next_Node]));
                }
            }
        }

        System.out.println(distance[endNode]);

        br.close();
    }
}

class Edge57 implements Comparable<Edge57>{
    int targetNode;
    int value;
    Edge57(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }

    @Override
    public int compareTo(Edge57 o) {
        return this.value - o.value;
    }
}


