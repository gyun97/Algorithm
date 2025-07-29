import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] costs;
    static int answer = Integer.MAX_VALUE;

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        costs = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][RED] = Integer.parseInt(st.nextToken());
            costs[i][GREEN] = Integer.parseInt(st.nextToken());
            costs[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        answer = Math.min(answer, firstRed());
        answer = Math.min(answer, firstGreen());
        answer = Math.min(answer, firstBlue());

        System.out.println(answer);

    }

    // 첫 번째 집을 BLUE로 고정한 경우
    private static int firstBlue() {
        int[][] dp = new int[N + 1][3];
        dp[1][BLUE] = costs[1][BLUE];
        dp[1][RED] = INF;
        dp[1][GREEN] = INF;

        for (int i = 2; i <= N; i++) {
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + costs[i][BLUE];
            dp[i][RED] = Math.min(dp[i - 1][BLUE], dp[i - 1][GREEN]) + costs[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + costs[i][GREEN];
        }


        // N번째 집은 BLUE 불가
        return Math.min(dp[N][RED], dp[N][GREEN]);
    }

    // 첫 번째 집을 GREEN으로 고정한 경우
    private static int firstGreen() {
        int[][] dp = new int[N + 1][3];
        dp[1][GREEN] = costs[1][GREEN];
        dp[1][RED] = INF;
        dp[1][BLUE] = INF;

        for (int i = 2; i <= N; i++) {
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + costs[i][GREEN];
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + costs[i][RED];
            dp[i][BLUE] = Math.min(dp[i - 1][RED], dp[i - 1][GREEN]) + costs[i][BLUE];
        }

        // N번째 집은 GREEN 불가
        return Math.min(dp[N][RED], dp[N][BLUE]);
    }

    // 첫 번째 집을 RED로 고정한 경우
    private static int firstRed() {
        int[][] dp = new int[N + 1][3];

        // 초기값 설정
        dp[1][RED] = costs[1][RED];
        dp[1][GREEN] = INF;
        dp[1][BLUE] = INF;

        for (int i = 2; i <= N; i++) {
            dp[i][RED] = Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]) + costs[i][RED];
            dp[i][GREEN] = Math.min(dp[i - 1][RED], dp[i - 1][BLUE]) + costs[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i - 1][GREEN], dp[i - 1][RED]) + costs[i][BLUE];
        }

        // N번 집은 RED 불가
        return Math.min(dp[N][BLUE], dp[N][GREEN]);
    }


}