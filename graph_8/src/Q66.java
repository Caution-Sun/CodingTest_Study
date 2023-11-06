import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q66 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sum = 0;

        PriorityQueue<Edge66> queue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for(int j = 0; j < N; j++){
                int temp = 0;
                if(tempc[j] >= 'a' && tempc[j] <= 'z')
                    temp = tempc[j] - 'a' + 1;
                else if(tempc[j] >= 'A' && tempc[j] <= 'Z')
                    temp = tempc[j] - 'A' + 1;

                sum += temp;

                if(i != j && temp != 0)
                    queue.add(new Edge66(i, j, temp));
            }
        }

        parent = new int[N];
        for(int i = 0; i < N; i++)
            parent[i] = i;
        int useEdge = 0;
        int result = 0;

        while (!queue.isEmpty()){
            Edge66 now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        if(useEdge == N - 1)
            System.out.println(sum - result);
        else
            System.out.println(-1);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}
class Edge66 implements Comparable<Edge66>{
    int s, e, v;
    Edge66(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge66 o) {
        return this.v - o.v;
    }
}
