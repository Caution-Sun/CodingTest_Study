import java.util.Scanner;

public class Q31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int start = 1;
        int end = k;
        int answer = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int count = 0;

            for(int i = 1; i <= N; i++){
                count += Math.min(mid/i, N);
            }

            if(count < k){
                start = mid + 1;
            }else{
                end = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
