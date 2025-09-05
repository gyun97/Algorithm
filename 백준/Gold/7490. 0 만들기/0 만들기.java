import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

        dfs(N, 1, "1");
        sb.append("\n");
        }

        System.out.println(sb);


    }

    private static void dfs(int N, int idx, String expr) {
        if (idx == N) {
            if (calculate(expr) == 0) {
                sb.append(expr).append("\n");
            }
            return;
        }

        int next = idx + 1;
        dfs(N, next, expr + " " + next);
        dfs(N, next, expr + "+" + next);
        dfs(N, next, expr + "-" + next);

    }

    private static int calculate(String expr) {
        String str = expr.replace(" ", "");
        Iterator<Integer> it = Arrays.stream(str.split("[+, -]")).map(Integer::parseInt).iterator();
        int result = it.next();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '+') {
                result += it.next();
            }else if(str.charAt(i) == '-') {
                result -= it.next();
            }
        }

        return result;
    }
}

