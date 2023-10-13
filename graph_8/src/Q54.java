import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q54 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for(int i = 1; i < N+1; i++){
            A[i] = new ArrayList<Integer>();
        }

        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1];
        int[] result = new int[N+1];

        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1){
                    break;
                }
                A[tmp].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N+1; i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < A[now].size(); i++){
                indegree[A[now].get(i)]--;
                result[A[now].get(i)] = Math.max(result[A[now].get(i)], result[now] + selfBuild[now]);

                if(indegree[A[now].get(i)] == 0){
                    queue.add(A[now].get(i));
                }
            }
        }

        for(int i = 1; i < N+1; i++){
            System.out.println(result[i] + selfBuild[i]);
        }

        br.close();
    }
}
