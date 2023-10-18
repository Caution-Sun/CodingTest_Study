import java.util.Scanner;

public class Q82 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] D = new int[202][202];
        for(int i = 0; i <= 200; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    D[i][j] = 1;
                }else{
                    D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                    if(D[i][j] > 1000000000){
                        D[i][j] = 1000000001;
                    }
                }
            }
        }

        if(D[N + M][M] < K){
            System.out.println("-1");
        }else {
            while(!(N == 0 && M == 0)){
                if(D[N + M - 1][M] >= K){
                    System.out.print("a");
                    N--;
                }else{
                    System.out.print("z");
                    K = K - D[N + M - 1][M];
                    M--;
                }
            }
        }
    }
}
