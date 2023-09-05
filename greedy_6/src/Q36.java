import java.util.Scanner;

public class Q36 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        String expression = sc.nextLine();
        String[] str = expression.split("-");

        for(int i = 0; i < str.length; i++){
            int tmp = mySum(str[i]);

            if(i == 0)
                answer += tmp;
            else
                answer -= tmp;
        }

        System.out.println(answer);
    }

    static int mySum(String a){
        int sum = 0;

        String[] tmp = a.split("[+]");
        for(int i = 0; i < tmp.length; i++){
            sum += Integer.parseInt(tmp[i]);
        }
        return sum;
    }
}
