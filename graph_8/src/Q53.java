import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q53 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer>[] A = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[N+1];

        for(int i = 0; i < M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            indegree[E]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N+1; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + ", ");
            for(int i = 0; i < A[now].size(); i++){
                indegree[A[now].get(i)]--;
                if(indegree[A[now].get(i)] == 0){
                    queue.add(A[now].get(i));
                }
            }
        }
    }
}
