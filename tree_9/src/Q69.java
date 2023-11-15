import java.util.Scanner;

public class Q69 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node69 root = new Node69();

        for(int i = 0; i < n; i++){
            String text = sc.next();
            Node69 now = root;

            for(int j = 0; j < text.length(); j++){
                char c = text.charAt(j);

                if(now.next[c - 'a'] == null){
                    now.next[c - 'a'] = new Node69();
                }

                now = now.next[c - 'a'];

                if(j == text.length() - 1){
                    now.isEnd = true;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            String text = sc.next();
            Node69 now = root;

            for(int j = 0; j < text.length(); j++){
                char c = text.charAt(j);

                if(now.next[c - 'a'] == null){
                    break;
                }

                now = now.next[c - 'a'];

                if(j == text.length() - 1 && now.isEnd == true){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

class Node69{
    Node69[] next = new Node69[26];
    boolean isEnd;
}
