import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // - 1하는 경우

            if (i % 3 == 0) { // 3 나누는 경우
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) { // 2 나누는 경우
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

        }

        sb.append(dp[N]);
        System.out.println(sb);
    }
}






