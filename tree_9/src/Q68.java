import java.util.ArrayList;
import java.util.Scanner;

public class Q68 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer;
    static int deleteNode;
    static int root;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        tree = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++){
            int node = sc.nextInt();
            if(node != -1){
                tree[i].add(node);
                tree[node].add(i);
            }else{
                root = i;
            }
        }

        deleteNode = sc.nextInt();

        if(deleteNode == 0){
            System.out.println(0);
        }else{
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int node){
        visited[node] = true;
        int cNodeNum = 0;
        for(int i : tree[node]){
            if(visited[i] == false && i != deleteNode){
                cNodeNum++;
                DFS(i);
            }
        }
        if(cNodeNum == 0){
            answer++;
        }
    }
}
