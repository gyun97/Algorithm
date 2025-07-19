import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] lines;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        dp = new int[N];

        Arrays.sort(lines, Comparator.comparingInt((int[] a) -> a[0])); // A 기준으로 정렬

        for (int i = 0; i < N; i++) {
            max = Math.max(max, recur(i));
        }

        System.out.println(N - max);


    }

    private static int recur(int N) {
        if (dp[N] == 0) {
            dp[N] = 1;

            for (int i = N + 1; i < lines.length; i++) {
                if (lines[N][1] < lines[i][1]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }

            }



        }
        return dp[N];

    }

}

