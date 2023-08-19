import java.util.Scanner;

public class Q30 {
    static int N;
    static int M;
    static int[] A;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int start = 0;
        int end = 0;

        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            if(start < A[i])
                start = A[i];
            end += A[i];
        }

        while(start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for(int i = 0; i < N; i++){
                if(sum + A[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            if(sum != 0)
                count++;

            if(count > M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start);
    }
}
