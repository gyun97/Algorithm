import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] A = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            A[i][0] = sc.nextInt(); // 시간
            A[i][1] = sc.nextInt(); // 보상
        }

        int[] dp = new int[N + 2];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            int days = A[i][0];
            int pay = A[i][1];

            dp[i] = Math.max(dp[i - 1], dp[i]);
            
            if (i + days <= N + 1) {
                dp[i + days] = Math.max(dp[i + days], dp[i] + pay);
                if (max < dp[i + days]) {
                    max = dp[i + days];
                }
            }

        }
//        System.out.println(Arrays.deepToString(A));
//        System.out.println(Arrays.toString(dp));
        System.out.println(max);


    }
}
