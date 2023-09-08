import java.util.Scanner;

public class Q39 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[1000001];

        for(int i = 2; i < A.length; i++)
            A[i] = i;

        for(int i = 2; i < Math.sqrt(A.length); i++){
            if(A[i] == 0)
                continue;

            for(int j = i * 2; j < A.length; j = j + i){
                A[j] = 0;
            }
        }

        int i = N;
        while(true){
            if(A[i] != 0){
                if(isPallindrome(A[i])){
                    System.out.println(A[i]);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPallindrome(int target) {
        char tmp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = tmp.length - 1;

        while(s < e){
            if(tmp[s] != tmp[e])
                return false;

            s++;
            e--;
        }

        return true;
    }
}
