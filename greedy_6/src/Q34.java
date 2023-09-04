import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q34 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());    // 양수는 내림차순 정렬
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();

            if (data > 1)
                plusPq.add(data);
            else if (data < 0)
                minusPq.add(data);
            else if (data == 1)
                one += 1;
            else if (data == 0)
                zero += 1;
        }

        int sum = 0;

        while(plusPq.size() > 1){
            int a = plusPq.remove();
            int b = plusPq.remove();
            sum += a * b;
        }
        if(!plusPq.isEmpty())
            sum += plusPq.remove();

        while(minusPq.size() > 1){
            int a = minusPq.remove();
            int b = minusPq.remove();
            sum += a * b;
        }
        if(!minusPq.isEmpty()){
            if(zero == 0)
                sum += minusPq.remove();
        }

        sum += one;

        System.out.println(sum);
    }
}

