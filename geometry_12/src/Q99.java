import java.util.Scanner;

public class Q99 {
    static int parent[];
    static int L[][];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = -1;
        }

        L = new int[N + 1][4];
        for(int i = 1; i <= N; i++){
            L[i][0] = sc.nextInt();
            L[i][1] = sc.nextInt();
            L[i][2] = sc.nextInt();
            L[i][3] = sc.nextInt();

            for(int j = 1; j < i; j++){
                if(isCross(L[i][0], L[i][1], L[i][2], L[i][3], L[j][0], L[j][1], L[j][2], L[j][3]))
                    union(i, j);
            }
        }

        int ans = 0;
        int res = 0;
        for(int i = 1; i <= N; i++){
            if (parent[i] < 0){
                ans++;
                res = Math.min(res, parent[i]);
            }
        }

        System.out.println(ans);
        System.out.println(-res);
    }

    static private int CCW(long x1, long y1, long x2, long y2, long x3, long y3){
        long tmp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);

        if(tmp > 0)
            return 1;
        else if(tmp < 0)
            return -1;

        return 0;
    }

    private static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        if(Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
        && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
            return true;

        return false;
    }

    private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        int abc = CCW(x1, y1, x2, y2, x3, y3);
        int abd = CCW(x1, y1, x2, y2, x4, y4);
        int cda = CCW(x3, y3, x4, y4, x1, y1);
        int cdb = CCW(x3, y3, x4, y4, x2, y2);

        if(abc * abd == 0 && cda * cdb == 0)
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        else if(abc * abd <= 0 && cda * cdb <= 0)
            return true;

        return false;
    }

    private static int find(int i){
        if(parent[i] < 0)
            return i;
        return parent[i] = find(parent[i]);
    }

    private static void union(int i, int j){
        int p = find(i);
        int q = find(j);

        if(p == q)
            return;
        parent[p] += parent[q];
        parent[q] = p;
    }
}
