import java.util.Scanner;

public class Q73 {
    static int MOD = 1000000007;
    static int[] tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();

        int k = 0;
        while(Math.pow(2,k) < N){
            k++;
        }

        int treeSize = (int)Math.pow(2, k) * 2;
        tree = new int[treeSize];
        for(int i = 1; i < treeSize; i++){
            tree[i] = 1;
        }

        int startIndex = (int)Math.pow(2,k);
        for(int i = 0; i < N; i++){
            tree[i + startIndex] = sc.nextInt();
        }

        for(int i = startIndex-1 ; i > 0; i--){
            tree[i] = (tree[i * 2] % MOD) * (tree[(i * 2) + 1] % MOD) % MOD;
        }

        for(int i = 0; i < K + M; i++){
            int a = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();

            if(a == 1){
                changeVal(s + (int)Math.pow(2, k) - 1, e);
            }else if(a == 2){
                System.out.println(getMul(s + (int)Math.pow(2, k) - 1, e + (int)Math.pow(2 , k)- 1));
            }
        }
    }

    static void changeVal(int s, int e){
        tree[s] = e;
        while(s > 1){
            s = s / 2;
            tree[s] = (tree[s * 2] % MOD) * (tree[(s * 2) + 1] % MOD) % MOD;
        }
    }

    static int getMul(int s, int e){
        int Mul = 1;

        while(s <= e){
            if(s % 2 == 1){
                Mul *= tree[s];
                s++;
            }
            if(e % 2 == 0){
                Mul *= tree[e];
                e--;
            }

            s = s / 2;
            e = e / 2;
        }
        return Mul;
    }
}
