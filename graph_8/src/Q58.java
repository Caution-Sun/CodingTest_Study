import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q58 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] W = new int[1001][1001];
        // ArrayList<Node58>[] W = new ArrayList[N + 1];

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for(int i = 1; i < N+1; i++){
            distQueue[i] = new PriorityQueue<Integer>(K, cp);
            // W[i] = new ArrayList<Node58>;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            W[S][E] = V;
            // W[S].add(new Node58(E, V));
        }

        PriorityQueue<Node58> pq = new PriorityQueue<>();
        pq.add(new Node58(1, 0));
        distQueue[1].add(0);
        while (!pq.isEmpty()){
            Node58 nowNode = pq.poll();
            for(int nextNode = 1; nextNode < N+1; nextNode++){
                if(W[nowNode.node][nextNode] != 0){             // for(int i = 0; i < W[nowNode].size(); i++) {
                    if(distQueue[nextNode].size() < K){
                        distQueue[nextNode].add(nowNode.value + W[nowNode.node][nextNode]);
                        pq.add(new Node58(nextNode, nowNode.value + W[nowNode.node][nextNode]));
                    } else if (distQueue[nextNode].peek() > nowNode.value + W[nowNode.node][nextNode]) {
                        distQueue[nextNode].poll();
                        distQueue[nextNode].add(nowNode.value + W[nowNode.node][nextNode]);
                        pq.add(new Node58(nextNode, nowNode.value + W[nowNode.node][nextNode]));
                    }
                }
            }
        }

        for(int i = 1; i < N+1; i++){
            if(distQueue[i].size() == K){
                System.out.println(distQueue[i].poll());
            }else {
                System.out.println(-1);
            }
        }

        br.close();
    }
}

class Node58 implements Comparable<Node58> {
    int node;
    int value;
    Node58(int node, int value){
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Node58 o) {
        return this.value < o.value ? -1 : 1;
    }
}
