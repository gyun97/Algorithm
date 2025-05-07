import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        long sum = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                } else {
                    /*
                    이 부분에서 dp[i][j] 값이 커지면 오버플로우 가능성 존재.
                    → 매번 모든 대입 시 % 1_000_000_000 을 꼭 해야 돼.
                     */
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            /*
            long 타입이라 당장 문제 없어 보여도, 모든 DP 값을 다 더하면 mod 범위를 넘길 수 있어.
            → 그래서 sum에도 %를 반드시 바로 적용해야 해.
             */
            sum = (sum + dp[N][i]) % 1000000000;
        }

//        System.out.println(Arrays.deepToString(dp));
        sb.append(sum);
        System.out.println(sb);
    }
}
