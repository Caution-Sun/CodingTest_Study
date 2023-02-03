import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9 {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0)
                checkSecret += 1;
        }

        for(int i = 0; i < P; i++){
            Add(A[i]);
        }
        if(checkSecret == 4)
            Result += 1;

        for(int i = P; i < S; i++){
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4)
                Result += 1;
        }

        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c){
        switch (c){
            case 'A' :
                myArr[0] += 1;
                if(myArr[0] == checkArr[0])
                    checkSecret += 1;
                break;
            case 'C' :
                myArr[1] += 1;
                if(myArr[1] == checkArr[1])
                    checkSecret += 1;
                break;
            case 'G' :
                myArr[2] += 1;
                if(myArr[2] == checkArr[2])
                    checkSecret += 1;
                break;
            case 'T':
                myArr[3] += 1;
                if(myArr[3] == checkArr[3])
                    checkSecret += 1;
                break;
        }
    }

    private static void Remove(char c){
        switch (c){
            case 'A':
                if(myArr[0] == checkArr[0])
                    checkSecret -= 1;
                myArr[0] -= 1;
                break;
            case 'C' :
                if(myArr[1] == checkArr[1])
                    checkSecret -= 1;
                myArr[1] -= 1;
                break;
            case 'G' :
                if(myArr[2] == checkArr[2])
                    checkSecret -= 1;
                myArr[2] -= 1;
                break;
            case 'T' :
                if(myArr[3] == checkArr[2])
                    checkSecret -= 1;
                myArr[3] -= 1;
                break;
        }
    }
}
