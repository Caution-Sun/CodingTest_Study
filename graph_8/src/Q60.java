import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q60 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] distance = new long[N];
        long[] cityMoney = new long[N];
        Edge[] edges = new Edge[M];

        Arrays.fill(distance,Long.MIN_VALUE);   // 최단 거리 배열 초기화

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s,e,v);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        distance[sCity] = cityMoney[sCity];

        for(int i = 0; i <= N + 100; i++){
            for(int j = 0; j < M; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int value = edges[j].value;

                if(start == Long.MIN_VALUE){
                    continue;
                }else if(start == Long.MAX_VALUE){
                    distance[end] = Long.MAX_VALUE;
                }else if(distance[end] < distance[start] + cityMoney[end] - value){
                    distance[end] = distance[start] + cityMoney[end] - value;

                    if(i >= N - 1){
                        distance[end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(distance[eCity] == Long.MIN_VALUE){
            System.out.println("gg");
        }else if(distance[eCity] == Long.MAX_VALUE){
            System.out.println("Gee");
        }else{
            System.out.println(distance[eCity]);
        }
    }

    static class Edge{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
