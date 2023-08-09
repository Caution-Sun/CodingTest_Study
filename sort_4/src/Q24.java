import java.util.Scanner;

public class Q24 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int jarisu){
        if(jarisu == N){
            if(isPrime(number))
                System.out.println(number);
            return;
        }

        for(int i = 1; i < 10; i++){
            if(i % 2 == 0)                        // 짝수라면 탐색할 필요가 없음
                continue;
            if(isPrime(number * 10 + i))    // 소수라면 재귀 함수로 자릿수를 늘림
                DFS(number * 10 + i, jarisu + 1);
        }
    }

    static boolean isPrime(int num){
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
