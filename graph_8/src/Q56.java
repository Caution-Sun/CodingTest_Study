import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q56 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        ArrayList<Node56>[] A = new ArrayList[V+1];
        for(int i = 1; i < V+1; i++){
            A[i] = new ArrayList<Node56>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            A[startNode].add(new Node56(endNode, value));
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

        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for(int i = 0; i < A[now].size(); i++){
                if(distance[A[now].get(i).targetNode] > distance[now] + A[now].get(i).value){
                    distance[A[now].get(i).targetNode] = distance[now] + A[now].get(i).value;
                    if(!visited[A[now].get(i).targetNode]){
                        queue.add(A[now].get(i).targetNode);
                        visited[A[now].get(i).targetNode] = true;
                    }
                }
            }
        }

        for(int i = 1; i < V+1; i++){
            if(distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }
}
class Node56{
    int targetNode;
    int value;
    Node56(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}
