import java.util.Scanner;

public class Q38 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            long Min = sc.nextInt();
            long Max = sc.nextInt();
            long[] A = new long[10000001];

            for(int i = 2; i < A.length; i++){
                A[i] = i;
            }

            for(int i = 2; i < Math.sqrt(A.length); i++){
                if(A[i] == 0)
                    continue;
                for(int j = i * 2; j < A.length; j = j + i)
                    A[j] = 0;
            }

            int count = 0;

            for(int i = 2; i < A.length; i++){
                if(A[i] != 0){
                    long tmp = A[i];

                    while((double)A[i] <= (double)Max/(double)tmp){
                        if((double)A[i] >= (double)Min/(double)tmp){
                            count++;
                        }
                        tmp = tmp * A[i];
                    }
                }
            }
            System.out.println(count);
        }
}
