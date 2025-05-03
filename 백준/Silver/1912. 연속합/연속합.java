import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int N, max;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        A = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(A));

        dp[0] = A[0];
        max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
            max = Math.max(max, dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
        recur(N - 1);
        System.out.println(max);
        
    }

    private static int recur(int idx) {

        if (dp[idx] == 0) {
            dp[idx] = Math.max(recur(idx - 1) + A[idx], A[idx]);
            max = Math.max(dp[idx], max);
        }

        return dp[idx];
    }
}
