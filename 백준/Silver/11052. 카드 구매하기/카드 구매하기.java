import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] card = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            card[i] = cur;
            dp[i] = cur;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }

        }

        System.out.println(dp[N]);;


    }
}


