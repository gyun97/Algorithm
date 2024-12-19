import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            sb.append(score[1]);
            System.out.println(sb);
            return;
        }

        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        sb.append(dp[n]);
        System.out.println(sb);

    }

}

