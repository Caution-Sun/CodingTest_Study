import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q33 {
    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < N; i++)
            pq.add(sc.nextInt());

        int sum = 0;

        while (pq.size() != 1){
            int a = pq.remove();
            int b = pq.remove();
            sum += a + b;
            pq.add(a + b);
        }

        System.out.println(sum);
    }
}
