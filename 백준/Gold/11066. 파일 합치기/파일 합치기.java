import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            int[] files = new int[K + 1];
            int[] sum = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i];
            }

            int[][] dp = new int[K + 1][K + 1];
            for (int length = 2; length <= K; length++) { // 합칠 챕터의 길이(개수)
                for (int start = 1; start <= K - length + 1; start++) { // 합칠 챕터들의 시작 챕터
                    int end = start + length - 1; // 합칠 챕터들의 마지막 챕터
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) { // 시작 챕터와 마지막 챕터의 중간 챕터
                        int cost = dp[start][mid] + dp[mid + 1][end] + (sum[end] - sum[start - 1]);
                        dp[start][end] = Math.min(dp[start][end], cost);
                    }
                }
            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);
    }
}
