import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n + 2];


            for (int i = 2; i < n + 2; i++) {
                dp[0][i] = Math.max(Math.max(dp[1][i - 1], dp[1][i - 2]), dp[0][i - 2]) + stickers[0][i - 2];
                dp[1][i] = Math.max(Math.max(dp[1][i - 2], dp[0][i - 2]), dp[0][i - 1]) + stickers[1][i - 2];
            }
            int max = Math.max(dp[0][n + 1], dp[1][n + 1]);
            sb.append(max).append("\n");


//            System.out.println(Arrays.deepToString(dp));

        }
        System.out.println(sb);

    }

}
