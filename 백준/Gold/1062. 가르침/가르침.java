import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, K, answer;
    static boolean[] visited;
    static String[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 단어의 개수
        K = Integer.parseInt(st.nextToken()); // 가르칠 수 있는 글자의 수
        words = new String[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words[i] = input.substring(4, input.length() - 4);
        }

        if (K < 5) {
            System.out.println(0);
            System.exit(0);
        } else if (K == 26) {
            System.out.println(N);
            System.exit(0);
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        backtracing(0, 0);
        System.out.println(answer);

    }

    private static void backtracing(int alphabet, int len) {
        if (K - 5 == len) {
            answer = Math.max(answer, reading());
            return;
        }

        for (int i = alphabet; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracing(i, len + 1);
                visited[i] = false;
            }
        }
    }

    private static int reading() {
        int count = 0;
        for (String str : words) {
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (!visited[str.charAt(i) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }

}


