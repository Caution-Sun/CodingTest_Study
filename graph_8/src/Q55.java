import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q55 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<dNode>[] A = new ArrayList[N+1];
        ArrayList<dNode>[] reverseA = new ArrayList[N+1];
        int[] indegree = new int[N+1];
        int[] result = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++){
            A[i] = new ArrayList<dNode>();
            reverseA[i] = new ArrayList<dNode>();
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            A[S].add(new dNode(E, value));
            reverseA[E].add(new dNode(S, value));
            indegree[E]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < A[now].size(); i++){
                indegree[A[now].get(i).targetNode] --;
                result[A[now].get(i).targetNode] = Math.max(result[A[now].get(i).targetNode], result[now] + A[now].get(i).value);

                if(indegree[A[now].get(i).targetNode] == 0){
                    queue.add(A[now].get(i).targetNode);
                }
            }
        }

        int resultCount = 0;
        queue = new LinkedList<>();
        queue.add(endNode);
        visited[endNode] = true;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < reverseA[now].size(); i++){
                if(result[reverseA[now].get(i).targetNode] + reverseA[now].get(i).value == result[now]){
                    resultCount++;
                    if(!visited[reverseA[now].get(i).targetNode]){
                        visited[reverseA[now].get(i).targetNode] = true;
                        queue.add(reverseA[now].get(i).targetNode);
                    }
                }
            }
        }

        System.out.println(result[endNode]);
        System.out.println(resultCount);
    }
}
class dNode{
    int targetNode;
    int value;
    dNode(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}
