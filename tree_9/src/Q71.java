import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q71 {
    public static int[] tree;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 1;
        int k = 0;
        while(treeHeight < N){
            treeHeight *= 2;
            k ++;
        }

        int treeSize = (int)Math.pow(2, k) * 2;
        int start_index = (int)Math.pow(2, k);
        tree = new int[treeSize];

        for(int i = 0; i < N; i++){
            tree[i + start_index] = Integer.parseInt(br.readLine());
        }

        for(int i = start_index-1; i > 0; i--){
            tree[i] = tree[i * 2] + tree[(i * 2) + 1];
        }

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(a == 1){
                changeVal(s + (int)Math.pow(2, k) - 1 ,e);
            }else if(a == 2){
                System.out.println(getSum(s + (int)Math.pow(2, k) - 1, e + (int)Math.pow(2, k) - 1));
            }
        }

        br.close();
    }

    public static void changeVal(int start_index, int value){
        int diff = value - tree[start_index];
        while (start_index > 0){
            tree[start_index] += diff;
            start_index = start_index / 2;
        }
    }

    public static int getSum(int start_index, int end_index){
        int sum = 0;
        while (start_index <= end_index){
            if(start_index % 2 == 1){
                sum += tree[start_index];
                start_index++;
            }
            if (end_index % 2 == 0){
                sum += tree[end_index];
                end_index--;
            }

            start_index = start_index / 2;
            end_index = end_index / 2;
        }

        return sum;
    }
}
