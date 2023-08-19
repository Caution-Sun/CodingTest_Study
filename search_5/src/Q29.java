import java.util.Arrays;
import java.util.Scanner;

public class Q29 {
    static int N;
    static int M;
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        Arrays.sort(A);

        M = sc.nextInt();

        for(int i = 0; i < M; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = N-1;

            while(start <= end){
                int mid = (start + end) / 2;
                int mid_value = A[mid];
                if(mid_value < target)
                    start = mid + 1;
                else if (mid_value > target)
                    end = mid - 1;
                else{
                    find = true;
                    break;
                }
            }

            if(find == true)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
