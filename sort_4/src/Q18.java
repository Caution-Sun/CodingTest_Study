import java.util.Scanner;

public class Q18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        int[] S = new int[N];

        for(int i = 1; i < N; i++){
            int insert_point = i;
            int insert_value = A[i];

            for(int j = i-1; j >= 0; j--){
                if(A[i] > A[j]){
                    insert_point = j+1;
                    break;
                }
                if(j == 0)
                    insert_point = 0;
            }

            for(int j = i-1; j >= insert_point; j--){
                A[j+1] = A[j];
            }

            A[insert_point] = insert_value;
        }

        S[0] = A[0];
        for(int i = 1; i < N; i++){
            S[i] = S[i-1] + A[i];
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            result += S[i];
        }

        System.out.println(result);
    }
}
