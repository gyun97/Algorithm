import java.util.*;

public class Main {
    static int N;
    static int[][] house;
    static long[][][] dp; // dp[r][c][d]: r,c 위치에서 방향 d로 도달하는 경우의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        house = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        // 초기 상태: (1,1)-(1,2) 가로로 시작
        dp[1][2][0] = 1;

        for (int r = 1; r <= N; r++) {
            for (int c = 3; c <= N; c++) {
                if (house[r][c] == 1) continue; // 벽이면 건너뛰기

                // 가로 이동
                dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];

                // 세로 이동
                if (r > 1)
                    dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];

                // 대각선 이동
                if (r > 1 && house[r - 1][c] == 0 && house[r][c - 1] == 0)
                    dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
            }
        }

        long answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(answer);
    }
}
