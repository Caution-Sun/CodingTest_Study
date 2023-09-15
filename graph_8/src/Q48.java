import java.util.ArrayList;
import java.util.Scanner;

public class Q48 {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            int V = sc.nextInt();
            int E = sc.nextInt();

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;

            for(int j = 1; j <= V; j++)
                A[j] = new ArrayList<Integer>();

            for(int j = 0; j < E; j++){
                int Start = sc.nextInt();
                int End = sc.nextInt();

                A[Start].add(End);
                A[End].add(Start);
            }

            for(int j = 1; j <= V; j++){
                if(IsEven)
                    DFS(j);
                else
                    break;
            }

            if(IsEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static void DFS(int Node){
        visited[Node] = true;

        for(int i : A[Node]){
            if(!visited[i]){
                check[i] = (check[Node] + 1) % 2;
                DFS(i);
            }
            else if(check[Node] == check[i]){
                IsEven = false;
            }
        }
    }
}
