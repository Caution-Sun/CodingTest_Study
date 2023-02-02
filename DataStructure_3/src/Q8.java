import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;

        for(int k = 0; k < N; k++){
            int i = 0;
            int j = N-1;
            long find = A[k];

            while(i < j){
                if(A[i] + A[j] == find){
                    if(i != k && j != k){
                        count += 1;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k){
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else if (A[i] + A[j] > find) {
                    j--;
                }
            }
        }
        System.out.println(count);
        bf.close();
    }
}
