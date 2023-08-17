import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q25 {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static Boolean arrive;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arrive = false;

        A = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        }

        for(int i = 0; i < N; i++){
            DFS(i, 1);
            if(arrive)
                break;
        }

        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static void DFS(int v, int depth){
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }

        visited[v] = true;

        for(int i : A[v]){
            if(!visited[i])
                DFS(i,depth+1);
        }

        visited[v] = false;
    }

}
