import java.util.ArrayList;
import java.util.Scanner;

public class Q67 {
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        visited = new boolean[N+1];
        answer = new int[N+1];
        tree = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }

        DFS(1);

        for(int i = 2; i < N+1; i++){
            System.out.println(answer[i]);
        }

    }

    static void DFS(int a){
        visited[a] = true;
        for(int i = 0; i < tree[a].size(); i++){
            if(!visited[tree[a].get(i)]){
                answer[tree[a].get(i)] = a;
                DFS(tree[a].get(i));
            }
        }
    }
}
