import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Nation {
    int x; // 행
    int y; // 열
    int population; // 인구

    public Nation(int x, int y, int population) {
        this.x = x;
        this.y = y;
        this.population = population;
    }

}

public class Main {
    static int N, L, R, count;
    static int[][] nations;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전 개수
        int K = Integer.parseInt(st.nextToken()); // 동전 가치의 합

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

//        System.out.println(Arrays.toString(dp));
        if (dp[K] != 10001) System.out.println(dp[K]);
        else System.out.println(-1);;
    }
}











