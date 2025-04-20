import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서
            int M = Integer.parseInt(st.nextToken()); // 동

            sb.append(comb(M, N)).append("\n");

        }
        System.out.println(sb);

    }

    private static int comb(int n, int r) {
        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);

    }


}



