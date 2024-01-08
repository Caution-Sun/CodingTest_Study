import java.util.Scanner;

public class Q96 {
    static int N;
    static int maxLength;

    static int A[];
    static int B[];
    static int D[];
    static int ans[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N + 1];
        B = new int[N + 1];
        D = new int[N + 1];
        ans = new int[N + 1];

        for(int i = 1; i <= N; i++){
            A[i] = sc.nextInt();
        }

        maxLength = 1;
        B[maxLength] = A[1];
        D[1] = maxLength;

        for(int i = 2; i <= N; i++){
            if(B[maxLength] < A[i]){
                B[++maxLength] = A[i];
                D[i] = maxLength;
            }else{
                int index = binarySearch(1, maxLength, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }

        System.out.println(maxLength);

        int index = maxLength;

        for(int i = N; i >= 1; i--){
            if(D[i] == maxLength){
                ans[maxLength] = A[i];
                maxLength--;
            }
        }

        for(int i = 1; i <= index; i++){
            System.out.print(ans[i] + " ");
        }

    }

    static int binarySearch(int l, int r, int now){
        int mid = 0;

        while(l < r){
            mid = (l + r) / 2;

            if(B[mid] < now)
                l = mid+1;
            else
                r = mid;
        }

        return l;
    }
}
