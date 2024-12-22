import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[i] = i를 제곱수 합으로 표현할 때 최소 개수
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i; // 최악의 경우 (1^2을 i번 더하는 경우)
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
