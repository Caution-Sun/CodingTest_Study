import java.util.Scanner;

public class Q97 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);

        int answer = 0;

        if(ccw < 0)
            answer = -1;
        else if(ccw > 0)
            answer = 1;
        else
            answer = 0;

        System.out.println(answer);
    }
}
