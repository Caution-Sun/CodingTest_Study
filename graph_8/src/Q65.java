import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q65 {
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    static int[] parent;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> islandList;
    static ArrayList<int[]> mlist;
    static PriorityQueue<Edge65> queue;
    static int N, M, sNum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS로 섬 구분하기
        sNum = 1;
        islandList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && visited[i][j] != true){
                    BFS(i, j);
                    sNum++;
                    islandList.add(mlist);
                }
            }
        }

        // 섬의 각 지점에서 만들 수 있는 모든 에지 저장하기
        queue = new PriorityQueue<>();
        for(int i = 0; i < islandList.size(); i++){
            // 섬의 정보 가져오기
            ArrayList<int[]> now = islandList.get(i);
            // 섬의 모든 지점에서 탐색하기
            for(int j = 0; j < now.size(); j++){
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_Island = map[r][c];
                // 4 방향 검색
                for(int d = 0; d < 4; d++){
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int blength = 0;
                    while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M){
                        // 같은 섬일 경우
                        if(map[r + tempR][c + tempC] == now_Island)
                            break;
                        // 같은 섬이 아니고, 바다가 아닐 경우(다른 섬에 닿은 경우)
                        else if(map[r + tempR][c + tempC] != 0){
                            if(blength > 1)
                                queue.add(new Edge65(now_Island, map[r + tempR][c + tempC], blength));
                            break;
                        } else  // 바다인 경우
                            blength++;

                        if(tempR < 0)
                            tempR--;
                        else if(tempR > 0)
                            tempR++;
                        else if(tempC < 0)
                            tempC--;
                        else if(tempC > 0)
                            tempC++;
                    }
                }
            }
        }

        // 최소 신장 트리 알고리즘 수행
        parent = new int[sNum];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()){
            Edge65 now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        if(useEdge == sNum - 2){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while (!queue.isEmpty()){
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            // 현재 위치에서 4방향으로 탐색
            for(int d = 0; d < 4; d++){
                int tempR = dr[d];
                int tempC = dc[d];
                while(r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M){
                    // 방문한 적 없고, 바다가 아니라면 같은 섬으로 취급
                    if(visited[r + tempR][c + tempC] == false && map[r + tempR][c + tempC] != 0){
                        addNode(r + tempR, c + tempC, queue);
                    }else
                        break;

                    if(tempR < 0)
                        tempR--;
                    else if(tempR > 0)
                        tempR++;
                    else if(tempC < 0)
                        tempC--;
                    else if (tempC > 0)
                        tempC++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int []> queue){
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = {i, j};
        mlist.add(temp);
        queue.add(temp);
    }
}
class Edge65 implements Comparable<Edge65>{
    int s, e, v;
    Edge65(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge65 o) {
        return this.v - o.v;
    }
}
