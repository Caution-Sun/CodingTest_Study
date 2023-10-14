import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q64 {
    public static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        PriorityQueue<Edge64> queue = new PriorityQueue<>();

        for(int i = 1; i < N+1; i++){
            parents[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            queue.add(new Edge64(s, e, v));
        }

        int result = 0;
        int countNode = 0;
        while(countNode != N-1){
            Edge64 now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                countNode++;
            }
        }

        System.out.println(result);

        br.close();
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b)
            parents[b] = a;
    }

    public static int find(int a){
        if(a == parents[a])
            return a;
        else
            return parents[a] = find(parents[a]);
    }
}
class Edge64 implements Comparable<Edge64>{
    int s;
    int e;
    int v;
    Edge64(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge64 o) {
        return this.v - o.v;
    }
}
