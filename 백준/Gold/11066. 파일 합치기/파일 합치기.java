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
            int[] files = new int[K];
            int[] sum = new int[K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i + 1] = sum[i] + files[i];
            }

            int[][] dp = new int[K][K];

            for (int length = 2; length <= K; length++) {
                for (int start = 0; start <= K - length; start++) {
                    int end = start + length - 1;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {
                        int cost = dp[start][mid] + dp[mid + 1][end] + (sum[end + 1] - sum[start]);
                        dp[start][end] = Math.min(dp[start][end], cost);
                    }
                }
            }
//            System.out.println(Arrays.deepToString(dp));
            sb.append(dp[0][K - 1]).append("\n"); // 정답 저장
        }
        System.out.print(sb); // 결과 출력


    }
}
