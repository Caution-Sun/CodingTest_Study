import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q14 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
           int first_abs = Math.abs(o1);
           int second_abs = Math.abs(o2);

           // o1에 높은 우선순위를 주고싶다면 음수 return, o2에 높은 우선순위를 주고싶다면 양수 return
           if(first_abs == second_abs){
               return o1 > o2 ? 1 : -1;
           }else {
               return first_abs - second_abs;
           }
        });

        for(int i = 0; i < N; i++){
            int request = Integer.parseInt(br.readLine());

            if(request == 0){
                if(myQueue.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(myQueue.poll());
                }
            }else {
                myQueue.add(request);
            }
        }
    }
}
