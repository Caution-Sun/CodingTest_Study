import java.util.Scanner;

public class Q37 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N+1];

        for(int i = 2; i < N+1; i++){
            A[i] = i;
        }

        for(int i = 2; i < Math.sqrt(N); i++){
            if(A[i] == 0)
                continue;

            for(int j = i*2; j < N+1; j = j + i){
                A[j] = 0;
            }
        }

        for(int i = M; i < N+1; i++){
            if(A[i] != 0)
                System.out.println(A[i]);
        }
    }
}
