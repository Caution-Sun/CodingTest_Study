import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q47 {
    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        A = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i = 1; i <= N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            BFS(i);
        }

        int maxVal = 0;
        for(int i = 1; i <= N; i++){
            if(answer[i] > maxVal)
                maxVal = answer[i];
        }

        for(int i = 1; i <= N; i++){
            if(answer[i] == maxVal)
                System.out.print(i + " ");
        }


    }

    public static void BFS(int Node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            for(int i : A[now_Node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    answer[i]++;
                }
            }
        }
    }
}
