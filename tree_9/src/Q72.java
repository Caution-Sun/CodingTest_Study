import java.util.Scanner;

public class Q72 {
    static int[] tree;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int k = 0;
        while(Math.pow(2, k) < N){
            k++;
        }

        int treeSize = (int)Math.pow(2, k) * 2;
        tree = new int[treeSize];
        for(int i = 1; i < treeSize; i++){
            tree[i] = Integer.MAX_VALUE;
        }

        int startIndex = (int)Math.pow(2, k);
        for(int i = 0; i < N; i++){
            tree[i + startIndex] = sc.nextInt();
        }
        for(int i = startIndex - 1; i > 0; i--){
            tree[i] = Math.min(tree[i * 2], tree[(i * 2) + 1]);
        }

        for(int i = 0; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            int start_index = s + (int)Math.pow(2, k) - 1;
            int end_index = e + (int)Math.pow(2, k) - 1;

            System.out.println(getMin(start_index, end_index));
        }
    }

    public static int getMin(int s, int e){
        int Min = Integer.MAX_VALUE;

        while(s <= e){
            if(s % 2 == 1){
                Min = Math.min(Min, tree[s]);
                s++;
            }
            if(e % 2 == 0){
                Min = Math.min(Min, tree[e]);
                e--;
            }

            s = s / 2;
            e = e / 2;
        }
        return Min;
    }
}
