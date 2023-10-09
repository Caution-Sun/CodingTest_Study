import java.util.Scanner;

public class Q51 {
    public static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];
        int[][] city = new int[N+1][N+1];
        int[] route = new int[M+1];

        for(int i = 1; i < N+1; i++){
            parent[i] = i;
        }

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                city[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < M+1; i++){
            route[i] = sc.nextInt();
        }

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(city[i][j] == 1){
                    union(i, j);
                }
            }
        }

        int index = find(route[1]);
        for(int i = 2; i < route.length; i++){
            if(index != find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(b > a){
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}
