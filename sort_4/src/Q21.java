import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21 {
    public static int[] A, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        merge_sort(0, N-1);

        System.out.println(result);
    }

    private static void merge_sort(int s, int e) {
        if (e - s < 1)
            return;

        int m = (s + e) / 2;

        merge_sort(s, m);
        merge_sort(m + 1, e);

        for(int i = s; i <= e; i++){
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while(index1 <= m && index2 <= e){
            if(tmp[index1] < tmp[index2]){
                A[k] = tmp[index1];
                k++;
                index1++;
            }else {
                A[k] = tmp[index2];
                result = result + index2 - k;   // 뒤쪽 데이터 값이 작은 경우 result 업데이트
                k++;
                index2++;
            }
        }
        while(index1 <= m){
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= e){
            A[k] = tmp[index2];
            k++;
            index2++;
        }

    }
}
