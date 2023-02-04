import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10 {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();

        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(i, now));

            if(mydeque.getFirst().index <= i-L){
                mydeque.removeFirst();
            }

            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
