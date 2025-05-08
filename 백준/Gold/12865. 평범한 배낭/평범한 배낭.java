import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 가방에 넣을 수 있는 최대 무게

        int[][] A = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i][0] = Integer.parseInt(st.nextToken()); // 무게
            A[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

//        System.out.println(Arrays.deepToString(A));

        int[] dp = new int[K + 1]; // 0/1 배낭 문제에서는 배낭의 "무게"를 인덱스로 잡은 dp[K + 1] 배열을 써야 해. dp[w] = 최대 가치

        for (int i = 1; i <= N; i++) {
            int W = A[i][0];
            int V = A[i][1];
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }

        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[K]);


    }
}
